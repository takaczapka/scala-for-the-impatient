package chap3arrays

import org.scalatest.{Matchers, FunSuite}

import scala.collection.mutable.ArrayBuffer

class Ex6Suite extends FunSuite with Matchers {

  test("reverse sorted order of the array") {

    val given = Array(2, 43, 12, 54, 1)
    val expected = Array(54, 43, 12, 2, 1)

    given.sortWith(_ > _) should be(expected)
    given.sorted.reverse should be(expected)
  }

  test("reverse sorted order of the array buffer") {

    val given = ArrayBuffer(2, 43, 12, 54, 1)
    val expected = ArrayBuffer(54, 43, 12, 2, 1)

    given.sortWith(_ > _) should be(expected)
    given.sorted.reverse should be(expected)
  }
}
