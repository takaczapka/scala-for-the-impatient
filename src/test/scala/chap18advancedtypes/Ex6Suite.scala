package chap18advancedtypes

import org.scalatest.{FunSuite, Matchers}

class Ex6Suite extends FunSuite with Matchers {

  import Ex6._

  test("left, right, who gives a f**k") {

    foo(Array(1, 2, 5, 6), 4) should be (Left(2))
    foo(Array(1, 2, 3, 4, 5, 6), 4) should be (Right(3))
    foo(Array(1, 2, 3, 5, 6), 4) should be (Left(2))
    foo(Array(1, 2, 5, 6), 4) should be (Left(2))
  }
}
