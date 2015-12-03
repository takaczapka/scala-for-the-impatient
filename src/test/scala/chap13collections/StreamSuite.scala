package chap13collections

import org.scalatest.{Matchers, FunSuite}

class StreamSuite extends FunSuite with Matchers {

  // Notes
  // having stream as a val we can rely on a memonization of values, which will not happen when stream is
  // defined as a function.
  // however, the val hold on to the head of a stream, so it will not be garbage-collected and the evaluation of
  // infinite stream might bring out of memory errors.

  test("natural numbers stream as a val") {
    lazy val N: Stream[Int] = 1 #:: N.map(_ + 1)

    N.take(5).toSeq should be(Seq(1, 2, 3, 4, 5))
  }

  test("natural numbers stream, proving memonization") {
    var hitCounter = 0
    lazy val Naturals: Stream[Int] = 1 #:: Naturals.map { n =>
      hitCounter += 1
      n + 1
    }

    Naturals.take(3).toIndexedSeq should be(Seq(1, 2, 3))
    hitCounter should be(2)
    Naturals.take(3).toIndexedSeq should be(Seq(1, 2, 3))
    hitCounter should be(2)
    Naturals.take(4).toIndexedSeq should be(Seq(1, 2, 3, 4))
    hitCounter should be(3)
  }

  test("alternative natural numbers stream, with recursion, proving memonization") {
    var hitCounter = 0

    lazy val Naturals: Stream[Int] = {
      def Naturals(n: Int): Stream[Int] = n #:: {
        hitCounter += 1
        Naturals(n + 1)
      }
      Naturals(1)
    }

    Naturals.take(3).toIndexedSeq should be(Seq(1, 2, 3))
    hitCounter should be(2)
    Naturals.take(3).toIndexedSeq should be(Seq(1, 2, 3))
    hitCounter should be(2)
    Naturals.take(4).toIndexedSeq should be(Seq(1, 2, 3, 4))
    hitCounter should be(3)
  }

  test("natural numbers stream as a function not val, in which case memonization does not work") {
    var hitCounter = 0

    def Naturals: Stream[Int] = {
      def Naturals(n: Int): Stream[Int] = n #:: {
        hitCounter += 1
        Naturals(n + 1)
      }
      Naturals(1)
    }

    Naturals.take(3).toIndexedSeq should be(Seq(1, 2, 3))
    hitCounter should be(2)
    Naturals.take(3).toIndexedSeq should be(Seq(1, 2, 3))
    hitCounter should be(4)
    Naturals.take(4).toIndexedSeq should be(Seq(1, 2, 3, 4))
    hitCounter should be(7)
  }


  test("factorial stream") {
    lazy val N: Stream[Int] = 1 #:: N.map(_ + 1)
    lazy val factorial: Stream[Int] = 1 #:: factorial.zip(N.tail).map { case (c, b) => c * b }


    factorial take 5 should be(Seq(1, 2, 6, 24, 120))
  }

  test("ffasdas") {
    import scala.math.BigInt

    def fibs: Stream[BigInt] = {
      def fibs(a: Int, b: Int): Stream[BigInt] = a #:: fibs(b, a + b)
      fibs(1, 1)
    }

    fibs take 7 should be(Seq(1, 1, 2, 3, 5, 8, 13))
    fibs(120) should be(1919601489)
  }
}
