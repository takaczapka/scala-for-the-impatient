package chap4maps

import org.scalatest.{FunSuite, Matchers}

class Ex1Suite extends FunSuite with Matchers {

  import Ex1.discount

  test("discount the price") {
    discount(Map("guitar" -> 180, "flying saucer" -> 350)) should be (Map("guitar" -> 162, "flying saucer" -> 315))
  }
}
