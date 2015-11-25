package chap21implicits

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3.FactorialInt

  test("factorial operator") {

    1.! should be(1)
    (1!) should be(1)
    (5!) should be(120)
    (10!) should be(3628800)
  }
}
