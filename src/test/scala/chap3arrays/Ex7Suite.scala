package chap3arrays

import org.scalatest.{FunSuite, Matchers}

class Ex7Suite extends FunSuite with Matchers {

  test("remove duplicates") {

    Array(1, 2, 3).distinct should be(Array(1, 2, 3))
    Array(1, 2, 2, 3, 3).distinct should be(Array(1, 2, 3))
    Array(1, 1, 1, 1).distinct should be(Array(1))
  }
}
