package chap4maps

import org.scalatest.{FunSuite, Matchers}

class Ex9Suite extends FunSuite with Matchers {

  import Ex9.lteqgt

  test("lteqgt finds counts of values lower than, equal and greater than n") {
    lteqgt(Array(1, 2), 0) should be((0, 0, 2))
    lteqgt(Array(1, 2, 3), 2) should be((1, 1, 1))
    lteqgt(Array(1, 2, 3), 5) should be((3, 0, 0))
  }
}
