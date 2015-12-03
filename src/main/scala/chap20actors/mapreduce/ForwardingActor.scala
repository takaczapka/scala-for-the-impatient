package chap20actors.mapreduce

import akka.actor.{Actor, ActorRef}

object ForwardingActor {

  case class Forward(msg: Any, destination: ActorRef)

}

class ForwardingActor extends Actor {

  import ForwardingActor._

  var replyTo: ActorRef = _

  override def receive: Actor.Receive = {
    case Forward(msg, actor) =>
      replyTo = sender()
      actor ! msg
      context.become(waitingForReply)
  }

  def waitingForReply: Actor.Receive = {
    case msg =>
      replyTo ! msg
      context.become(receive)
  }
}
