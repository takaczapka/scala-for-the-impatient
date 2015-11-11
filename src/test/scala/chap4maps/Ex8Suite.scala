package chap4maps


import helpers.Generators._
import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

  import Ex8.minmax

  test("minmax for one elem array returns tuple of the same elem") {
    val v = anyInt
    minmax(Array(v)) should be(v -> v)
  }

  test("minmax finds min and max elem in the array") {
    minmax(Array(1, 2)) should be(1 -> 2)
    minmax(Array(1, 2, 0, 8, 4)) should be(0 -> 8)
  }
}
