package chap13collections

import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5.mkString

  test("mkString does what .mkString do") {

    val a = Array("Tom", "Fred", "Harry")

    mkString(a) should be(a.mkString(""))
    mkString(a, ",") should be(a.mkString(","))
    mkString(Seq.empty) should be(Seq.empty.mkString)
  }
}
