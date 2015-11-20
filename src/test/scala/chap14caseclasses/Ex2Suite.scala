package chap14caseclasses

import org.scalatest.{FunSuite, Matchers}

class Ex2Suite extends FunSuite with Matchers {

  import Ex2.swap

  test("sawp") {
    swap(1, 5) should be ((5, 1))
  }
}
