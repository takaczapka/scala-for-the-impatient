package chap20actors.mapreduce

import java.util.concurrent.TimeUnit

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import chap20actors.mapreduce.MapActor.Work
import chap20actors.mapreduce.ReduceActor.WorkFinished

import scala.concurrent.Await
import scala.util.Try

class MapReduce {

  def run[A, B, C](work: Work[A, B, C])(implicit timeout: Timeout = Timeout(10, TimeUnit.SECONDS)): Try[C] = {
    val system = ActorSystem("map-reduce-system")

    try {
      val entryActor = system.actorOf(Props(classOf[ForwardingActor]))
      val reduceActor = system.actorOf(Props(classOf[ReduceActor], entryActor))
      val workActorMaker = (c: ActorRefFactory) => c.actorOf(Props(classOf[WorkerActor], reduceActor))
      val mapperActor = system.actorOf(Props(classOf[MapActor], reduceActor, workActorMaker))

      val result = Await.result(entryActor ? ForwardingActor.Forward(work, mapperActor), timeout.duration)

      result.asInstanceOf[WorkFinished[Try[C]]].result
    } finally {
      system.terminate()
    }
  }
}
