package chap13collections

import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

  import Ex8.breakDown

  test("breakdown empty array") {
    breakDown(Array(), 4) should be (
      Array())
  }

  test("breakdown array with more coloums than elems") {
    breakDown(Array(1, 2), 4) should be (
      Array(Array(1, 2)))
  }


  test("breakdown array") {
    breakDown(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 4) should be (
      Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10)))
  }
}
