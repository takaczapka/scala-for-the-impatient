package chap13collections

import org.scalatest.{FunSuite, Matchers}

import scala.collection.mutable

class Ex3Suite extends FunSuite with Matchers {

  import Ex3.removeZeros

  test("Remove zeros from list on only zeros removes everything") {
    removeZeros(mutable.LinkedList(0)) should be(Nil)

    removeZeros(mutable.LinkedList(0, 0, 0)) should be(Nil)

    removeZeros(mutable.LinkedList(0, 0, 0, 0)) should be(Nil)
  }

  test("Remove zeros from list on non-zero elements doesn't remove anything") {
    removeZeros(mutable.LinkedList()) should be(Nil)

    removeZeros(mutable.LinkedList(1)) should be(List(1))

    removeZeros(mutable.LinkedList(1, 2, 3)) should be(List(1, 2, 3))
  }

  test("Remove zeros from mixed list filters out the zeros whithout touching the rest") {
    removeZeros(mutable.LinkedList(0, 1, 2, 3, 0, 0, 0, 2, 3, 0, 0, 0)) should be(List(1, 2, 3, 2, 3))
  }
}
