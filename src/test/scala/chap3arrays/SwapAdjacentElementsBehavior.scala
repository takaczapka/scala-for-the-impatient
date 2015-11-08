package chap3arrays

import org.scalatest.{Matchers, FunSuite}

trait SwapAdjacentElementsBehavior extends Matchers {
  this: FunSuite =>

  def swapAdjacentElements[T : Manifest](a: Array[T]): Array[T]

  test("swap of empty array results in empty array") {
    swapAdjacentElements(Array[Int]()) should be(Array[Int]())
  }

  test("swap of null array results in empty array") {
    swapAdjacentElements(null) should be(null)
  }

  test("swap of one element array results in one element array") {
    swapAdjacentElements(Array(1)) should be(Array(1))
  }

  test("swap of two elem array, swaps elements") {
    swapAdjacentElements(Array(1, 2)) should be(Array(2, 1))
  }

  test("swap of three elem array leaves the last element in place") {
    swapAdjacentElements(Array(1, 2, 3)) should be(Array(2, 1, 3))
  }

  test("swap applies to all elements of the array") {
    swapAdjacentElements(Array(1, 2, 3, 4, 5)) should be(Array(2, 1, 4, 3, 5))
  }


}
