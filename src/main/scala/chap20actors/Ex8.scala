package chap20actors

import akka.actor.{Props, ActorSystem, ActorRef, Actor}
import akka.actor.Actor.Receive
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * 8. Show how an actor-based program can deadlock when one sends synchronous messages.
  */
object Ex8 extends App {

  implicit val timeout = Timeout(10 seconds)

  class PingActor(pongActor: ActorRef) extends Actor {
    override def receive: Receive = {
      case "start" =>
        println("starting")
        val a = pongActor ! "ping"
      case "ping" =>
        println("ping")
        Await.result(pongActor ? "ping", timeout.duration)
    }
  }

  class PongActor() extends Actor {
    override def receive: Receive = {
      case "ping" =>
        println("pong")
        Await.result(sender() ? "ping", timeout.duration)
    }
  }

  val system = ActorSystem("sync-ping-pong")
  try {
    val pongActor = system.actorOf(Props(classOf[PongActor]))
    val pingActor = system.actorOf(Props(classOf[PingActor], pongActor))

    pingActor ! "start"

    Thread.sleep(100000)
  } finally {
    system.terminate()
  }
}
