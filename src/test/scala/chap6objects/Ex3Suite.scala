package chap6objects

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3._

  test("demonstrate that client code can change location of Origin sparingly") {

    val p1 = Origin
    val p2 = Origin

    p2.setLocation(0, 0)
    p1.setLocation(5, 7)

    assert(p2.getX == 5)
  }
}
