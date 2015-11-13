package chap13collections

import org.scalatest.{FunSuite, Matchers}

class Ex4Suite extends FunSuite with Matchers {

  import Ex4.doTheMagic

  test("do the magic") {
    val s = Array("Tom", "Fred", "Harry")
    val m = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

    doTheMagic(s, m) should be (Seq(3, 5))
  }
}
