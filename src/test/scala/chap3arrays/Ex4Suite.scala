package chap3arrays

import org.scalatest.{Matchers, FunSuite}

class Ex4Suite extends FunSuite with Matchers {

  import Ex4.orderIntArray

  test("Empty or null array is unaffected") {
    orderIntArray(null) should be(null)
    orderIntArray(Array[Int]()) should be(Array[Int]())
  }

  test("Array of only positive values should stay the same") {
    orderIntArray(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)) should be(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
  }

  test("Array of negative or zero values should stay the same") {
    orderIntArray(Array(-1, 0, -2, 0)) should be(Array(-1, 0, -2, 0))
  }

  test("Mixed values array should get ordered, first positive values, " +
    "then zero or negative values in the original order") {
    orderIntArray(Array(1, 2, -1, -2)) should be(Array(1, 2, -1, -2))
    orderIntArray(Array(-1, -2, 1, 2)) should be(Array(1, 2, -1, -2))
    orderIntArray(Array(0, -1, -2, 1, 2)) should be(Array(1, 2, 0, -1, -2))
  }
}
