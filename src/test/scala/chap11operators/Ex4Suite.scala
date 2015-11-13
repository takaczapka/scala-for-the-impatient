package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex4Suite extends FunSuite with Matchers {

  import Ex4._

  test("Money takes care about overflow of cents") {
    (Money(10, 111) == Money(11, 11)) should be(true)
    (Money(0, 111) == Money(1, 11)) should be(true)
    (Money(10, 1111) == Money(21, 11)) should be(true)
  }

  test("We can add and subtract money") {

    (Money(1, 75) + Money(0, 50)) should be(Money(2, 25))
    (Money(1, 75) - Money(0, 50)) should be(Money(1, 25))
    (Money(1, 75) - Money(1, 50)) should be(Money(0, 25))
    (Money(1, 75) - Money(1, 75)) should be(Money(0, 0))


    intercept[AssertionError] {
      Money(1, 75) - Money(3, 50)
    }
  }

  test("who has more?") {

    (Money(1, 23) < Money(1, 24)) should be(true)
    (Money(1, 23) < Money(2, 3)) should be(true)

    (Money(1, 23) < Money(1, 23)) should be(false)
  }
}
