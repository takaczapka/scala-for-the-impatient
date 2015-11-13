package chap12higherorderfunc

import org.scalatest.{FunSuite, Matchers}

class Ex2Suite extends FunSuite with Matchers {

  import Ex2.max

  test("in the search of max") {

    max(Array(1)) should be (1)

    max(Array(1, 2)) should be (2)
    max(Array(2, 1)) should be (2)

    max(Array(1, 2, 2, 1, 2, 2, 4, 2, 6)) should be (6)
  }
}
