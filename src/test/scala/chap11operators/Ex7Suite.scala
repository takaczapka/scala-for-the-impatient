package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex7Suite extends FunSuite with Matchers {

  import Ex7.BitSequence

  test("Bit setting") {
    val bs = new BitSequence(0)

    for (i <- 0 to 64) assert(bs(i) === 0)

    bs(10) = 1
    assert(bs(10) === 1)
    for (i <- 0 to 9) assert(bs(i) === 0)
    for (i <- 11 to 63) assert(bs(i) === 0)

    bs(10) = 0
    for (i <- 0 to 63) assert(bs(i) === 0)
  }

  test("toString on BitSequence") {
    val bs = new BitSequence(0)

    bs.toString should be ("0")

    bs(0) = 1
    bs.toString should be ("1")

    bs(5) = 1
    bs.toString should be ("100001")

    bs(63) = 1
    bs.toString should be ("1000000000000000000000000000000000000000000000000000000000100001")
  }
}
