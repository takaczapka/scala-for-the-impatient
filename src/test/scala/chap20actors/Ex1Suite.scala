package chap20actors

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import chap20actors.Ex1._
import org.scalatest._

import scala.concurrent.duration._

class Ex1Suite extends ActorSuite("test-system") {

  test("SliceSumActor responds with a result SliceSumResult message") {

    val actor = system.actorOf(Props[SliceSumActor])

    within(1 second) {
      actor ! ComputeSliceSum(Seq(1, 2, 3, 4), 1, 3)
      expectMsg(SliceSumResult(5))
    }
  }

  test("ComputeAvgActor sends a message AvgResult back once a result is ready") {
    val actor = system.actorOf(Props[ComputeAvgActor])

    within(1 second) {
      actor ! ComputeAvg(Seq(1, 2, 3), 2)
      expectMsg(AvgResult(2.0))
    }
  }
}

class Ex1HelperSuite extends FunSuite with Matchers {

  import Ex1Helper.ranges

  test("generate ranges") {
    ranges(1, 1) should be(Seq(0 -> 0))
    ranges(5, 1) should be(Seq(0 -> 4))
    ranges(2, 2) should be(Seq(0 -> 0, 1 -> 1))
    ranges(3, 3) should be(Seq(0 -> 0, 1 -> 1, 2 -> 2))
    ranges(10, 3) should be(Seq(0 -> 3, 4 -> 7, 8 -> 9))
    ranges(9, 3) should be(Seq(0 -> 2, 3 -> 5, 6 -> 8))
    ranges(9, 2) should be(Seq(0 -> 4, 5 -> 8))
    ranges(10, 2) should be(Seq(0 -> 4, 5 -> 9))
  }



  /// TODO
  def ranges2(untilBound: Int, chunks: Int) = {
    assert(chunks > 0)
    assert(untilBound >= chunks)

    val step = ((untilBound - 1) / chunks) + 1

    val s = for (i <- 0 to untilBound by step) yield i
    val s0 = if (s.last == untilBound) s else s :+ untilBound

    val s3: IndexedSeq[(Int, Int)] = s0.sliding(2).toIndexedSeq.map {
      case Seq(x: Int, y: Int) => x -> (y - 1)
    }

    s3
  }


  test("generate ranges2") {
    ranges2(1, 1) should be(Seq(0 -> 0))
    ranges2(5, 1) should be(Seq(0 -> 4))
    ranges2(2, 2) should be(Seq(0 -> 0, 1 -> 1))
    ranges2(3, 3) should be(Seq(0 -> 0, 1 -> 1, 2 -> 2))
    ranges2(10, 3) should be(Seq(0 -> 3, 4 -> 7, 8 -> 9))
    ranges2(9, 3) should be(Seq(0 -> 2, 3 -> 5, 6 -> 8))
    ranges2(9, 2) should be(Seq(0 -> 4, 5 -> 8))
    ranges2(10, 2) should be(Seq(0 -> 4, 5 -> 9))
  }
}