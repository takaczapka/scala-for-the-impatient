package chap14caseclasses

import org.scalatest.{FunSuite, Matchers}

import scala.math._

class Ex10Suite extends FunSuite with Matchers {

  import Ex10.compose

  test("composition examples") {
    def f(x: Double): Option[Double] = if (x >= 0) Some(sqrt(x)) else None

    def g(x: Double): Option[Double] = if (x != 1) Some(1 / (x - 1)) else None

    val h = compose(f, g)

    h(2) should be(Some(1))
    h(1) should be(None)
    h(0) should be(None)
  }
}
