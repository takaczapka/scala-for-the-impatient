package chap4maps

import org.scalatest.{FunSuite, Matchers}

import scala.collection.immutable.IndexedSeq

class Ex10Suite extends FunSuite with Matchers {

  test("demonstrate zipping of two strings") {
    "Hello".zip("World") should be (Seq(('H', 'W'), ('e', 'o'), ('l', 'r'), ('l', 'l'), ('o', 'd')))
  }
}
