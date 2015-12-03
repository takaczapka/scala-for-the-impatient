package chap20actors.mapreduce

import akka.actor.{ActorRefFactory, Props}
import akka.testkit.TestProbe

import Functions._
import chap20actors.ActorSuite
import chap20actors.mapreduce.MapActor._
import chap20actors.mapreduce.ReduceActor._
import chap20actors.mapreduce.WorkerActor._
import org.scalatest.{Matchers, FunSuite}

import scala.collection.mutable.ArrayBuffer

class MapReduceActorSystemSuite extends FunSuite with Matchers {

  test("get a system running") {

    val mapFunction = new MapFunction[String, String] {
      override def apply(t: String) = t.sliding(2, 2)
    }

    val reduceFunction = new ReduceFunction[Int] {
      override def apply(a: Int, b: Int): Int = a + b
    }
    val echoFunction = new ComputeFunction[String, Int] {
      override def apply(t: String): Int = t.length
    }

    val text =
      "Tyger! Tyger! burning bright, " +
        "In the forests of the night, " +
        "What immortal hand or eye " +
        "Could frame thy fearful symmetry?"

    val work = Work(text,
      mapFunction, reduceFunction, echoFunction)

    val result = new MapReduce().run(work)
    result should be(118)
  }


}


class MapReduceSuite extends ActorSuite("map-reduce-suite") {

  test("Map reduce brings the correct results") {
    val reduceActor = system.actorOf(Props(classOf[ReduceActor], testActor))
    val workActorMaker = (c: ActorRefFactory) => c.actorOf(Props(classOf[WorkerActor], reduceActor))
    val mapperActor = system.actorOf(Props(classOf[MapActor], reduceActor, workActorMaker))

    val reduceFunction = new ReduceFunction[Int] {
      override def apply(a: Int, b: Int): Int = a + b
    }
    val mapFunction = new MapFunction[String, String] {
      override def apply(t: String) = t.sliding(2, 2)
    }
    val echoFunction = new ComputeFunction[String, Int] {
      override def apply(t: String): Int = t.length
    }

    val text =
      "Tyger! Tyger! burning bright, " +
        "In the forests of the night, " +
        "What immortal hand or eye " +
        "Could frame thy fearful symmetry?"

    mapperActor ! Work(text,
      mapFunction, reduceFunction, echoFunction)

    expectMsg(WorkFinished(118))
  }
}

class WorkerActorSuite extends ActorSuite("worker-actor-suite") {

  val echoFunction = new ComputeFunction[String, String] {
    override def apply(t: String): String = t
  }

  test("Worker actor sends back a TaskResult once task received in Task message done") {
    val actorRef = system.actorOf(Props(classOf[WorkerActor], testActor))
    actorRef ! Task("echo", echoFunction)
    expectMsg(TaskResult("echo"))
  }
}

class ReduceActorSuite extends ActorSuite("reduce-actor-suite") {

  test("ReduceActor combines results and sends a message when it knows when to stop (WorkSent message received and all expected " +
    "TaskResult messages received") {

    val actorRef = system.actorOf(Props(classOf[ReduceActor], testActor))
    actorRef ! WorkSent(5, new ReduceFunction[Int]() {
      def apply(x: Int, y: Int) = {
        x + y
      }
    })
    actorRef ! TaskResult(1)
    actorRef ! TaskResult(1)
    actorRef ! TaskResult(2)
    actorRef ! TaskResult(2)
    actorRef ! TaskResult(3)
    expectMsg(WorkFinished(9))
  }

  test("ReduceActor combines any type of work together") {

    val actorRef = system.actorOf(Props(classOf[ReduceActor], testActor))
    actorRef ! WorkSent(3, new ReduceFunction[String]() {
      def apply(x: String, y: String) = {
        x + y
      }
    })
    actorRef ! TaskResult("a")
    actorRef ! TaskResult("b")
    actorRef ! TaskResult("c")
    expectMsg(WorkFinished("abc"))
  }

  test("ReduceActor combines correctly even if there is onle one message") {

    val actorRef = system.actorOf(Props(classOf[ReduceActor], testActor))
    actorRef ! WorkSent(1, new ReduceFunction[String]() {
      def apply(x: String, y: String) = {
        x + y
      }
    })
    actorRef ! TaskResult("a")
    expectMsg(WorkFinished("a"))
  }
}

class MapActorSuite extends ActorSuite("map-actor-suite") {

  test("MapActor sends WorkSent message to ReduceActor when all work is distributed") {
    val reduceActorProbe = TestProbe()

    val childProbes = ArrayBuffer[TestProbe]()
    val maker = (_: ActorRefFactory) => {
      val c = TestProbe()
      childProbes += c
      c.testActor
    }

    val actorRef = system.actorOf(Props(classOf[MapActor], reduceActorProbe.testActor, maker))

    val reduceFunction = new ReduceFunction[String] {
      override def apply(a: String, b: String): String = a + b
    }
    val mapFunction = new MapFunction[String, String] {
      override def apply(t: String) = t.sliding(2, 2)
    }
    val echoFunction = new ComputeFunction[String, String] {
      override def apply(t: String): String = t
    }

    actorRef ! Work("boombastics", mapFunction, reduceFunction, echoFunction)

    childProbes.foreach {
      _.expectMsgClass(classOf[Task[String, ComputeFunction[String, String]]])
    }

    reduceActorProbe.expectMsg(WorkSent(6, reduceFunction))
  }
}

