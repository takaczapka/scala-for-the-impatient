package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex1Suite extends FunSuite with Matchers {

  test("demonstrate that -> and + operators have the same precedence (-> is only extension of - operators " +
    "and the same rules apply") {
    assert((3 + 4 -> 5) === (7 -> 5))

    // 3 -> 4 + 5  // illegal as you can't add 5 to the tuple
  }
}
