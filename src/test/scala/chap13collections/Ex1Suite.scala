package chap13collections

import org.scalatest.{FunSuite, Matchers}

class Ex1Suite extends FunSuite with Matchers {

  import Ex1.indexes

  test("char indexes map") {

    indexes("") should be(Map.empty)

    indexes("a") should be(Map('a' -> Set(0)))

    indexes("aa") should be(Map('a' -> Set(0, 1)))

    indexes("abab") should be(Map('a' -> Set(0, 2), 'b' -> Set(1, 3)))

    indexes("Mississipi") should be(Map('M' -> Set(0), 'i' -> Set(1, 4, 7, 9), 's' -> Set(2, 3, 5, 6), 'p' -> Set(8)))
  }
}
