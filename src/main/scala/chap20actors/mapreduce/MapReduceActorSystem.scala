package chap20actors.mapreduce

import akka.actor.{Actor, ActorRef, ActorRefFactory, Stash}

import scala.collection.mutable.ArrayBuffer


object Functions {

  trait ComputeFunction[T, R] {
    def apply(t: T): R
  }

  trait ReduceFunction[T] {
    def apply(a: T, b: T): T
  }

  trait MapFunction[T, R] {
    def apply(t: T): Iterator[R]
  }

}

import chap20actors.mapreduce.Functions._

object WorkerActor {

  case class Task[T, R](data: T, f: ComputeFunction[T, R])

}

class WorkerActor(replyTo: ActorRef) extends Actor {

  import WorkerActor._

  override def receive: Receive = {
    case Task(data, f) =>
      replyTo ! ReduceActor.TaskResult(f(data))
  }
}


object MapActor {

  case class Work[A, B, C](data: A, mapFunction: MapFunction[A, B], reduceFunction: ReduceFunction[C], computeFunction: ComputeFunction[B, C])

}

class MapActor(reducer: ActorRef, workerMaker: ActorRefFactory => ActorRef) extends Actor {

  import MapActor._

  override def receive: Receive = {
    case Work(data, mapFunction, reduceFunction, computeFunction) =>
      val workItems = mapFunction(data).toSeq
      workItems.foreach { chunk =>
        workerMaker(context) ! WorkerActor.Task(chunk, computeFunction)
      }
      reducer ! ReduceActor.WorkSent(workItems.length, reduceFunction)
  }
}

object ReduceActor {

  case class WorkSent[T](numberOfTasks: Int, reduce: ReduceFunction[T])

  case class TaskResult[T](result: T)

  case class WorkFinished[T](result: T)

}

class ReduceActor(replyTo: ActorRef) extends Actor with Stash {

  import ReduceActor._

  var numberOfTasksToReceive: Int = _
  val results: ArrayBuffer[Any] = new ArrayBuffer[Any]()
  var reduceFunction: ReduceFunction[Any] = _

  override def receive: Receive = {
    case WorkSent(numberOfTasks, _reduceFunction) =>
      reduceFunction = _reduceFunction
      numberOfTasksToReceive = numberOfTasks
      results.clear()
      unstashAll()
      context.become(reduce)
    case msg => stash()
  }

  def reduce: Receive = {
    case TaskResult(taskResult) =>
      results.+=(taskResult)
      if (results.length == numberOfTasksToReceive) {
        var reduceResult = results.head
        results.tail.foreach { a =>
          reduceResult = reduceFunction(reduceResult, a)
        }
        replyTo ! WorkFinished(reduceResult)
        context.become(receive)
      }

  }
}