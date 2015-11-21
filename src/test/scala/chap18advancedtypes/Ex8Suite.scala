package chap18advancedtypes

import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

  import Ex8._

  test("print values applying some function") {

    printValues((x: Int) => x * x, 3, 6) should be ("9 16 25 36")
    printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6) should be ("3 5 8 13")
  }
}
