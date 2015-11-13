package chap12higherorderfunc

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3.factorial

  test("factorial with reduce left") {
    factorial(-2) should be(1)
    factorial(0) should be(1)
    factorial(1) should be(1)
    factorial(2) should be(2)
    factorial(5) should be(120)
    factorial(10) should be(3628800)
  }
}
