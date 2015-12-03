package chap20actors

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, FunSuiteLike, Matchers}

abstract class ActorSuite(systemName: String)
  extends TestKit(ActorSystem(systemName))
  with FunSuiteLike
  with ImplicitSender
  with Matchers
  with BeforeAndAfterAll {
  
  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }
}