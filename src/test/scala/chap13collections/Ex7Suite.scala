package chap13collections

import org.scalatest.{FunSuite, Matchers}

class Ex7Suite extends FunSuite with Matchers {

  val prices = List(5.0, 20.0, 9.95)
  val quantities: List[Int] = List(10, 2, 1)

  val expected = (prices zip quantities) map { p => p._1 * p._2 }

  test("apply tupled to the multiplication function") {

    val resultTupled = (prices zip quantities) map {
      ((_: Double) * (_: Int)).tupled // not sure if this could be done without type casting
    }

    resultTupled should be(expected)
  }

  test("tupled when function is not anonymous one") {
    val f: (Double, Int) => Double = (i, j) => i * j
    val fUnderscores: (Double, Int) => Double = _ * _

    (prices zip quantities) map f.tupled should be (expected)
    (prices zip quantities) map fUnderscores.tupled should be (expected)
  }
}
