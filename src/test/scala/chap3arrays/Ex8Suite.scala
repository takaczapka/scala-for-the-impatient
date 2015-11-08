package chap3arrays

import org.scalatest.{FunSuite, Matchers}

import scala.collection.mutable.ArrayBuffer

class Ex8Suite extends FunSuite with Matchers {

  import Ex8.removeAllNegativesButFirst

  test("remove all negatives but first, but keep all if there is not negative elems") {

    val buffer = ArrayBuffer(1, 2, 3)

    removeAllNegativesButFirst(buffer)

    buffer should be(buffer)
  }

  test("remove all negatives but first, but keep all if there is just one negative elems") {

    val buffer = ArrayBuffer(1, 2, -31, 3)

    removeAllNegativesButFirst(buffer)

    buffer should be(ArrayBuffer(1, 2, -31, 3))
  }

  test("remove all negatives but first") {

    val buffer = ArrayBuffer(1, 2, -31, 3, 4, -3, -1, 12)

    removeAllNegativesButFirst(buffer)

    buffer should be(ArrayBuffer(1, 2, -31, 3, 4, 12))
  }

}
