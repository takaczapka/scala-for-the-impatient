package chap4maps

import org.scalatest.{FunSuite, Matchers}

class Ex7Suite extends FunSuite with Matchers {

  import Ex7.tabbedOutput

  test("tabbed output for empty map is empty") {
    tabbedOutput(Map[String, String]()) should be("")
  }

  test("tabbed output for a one element map is simple line") {
    tabbedOutput(Map("a" -> "b")) should be("a | b")
  }

  test("tabbed output for a map is correctly tabbed") {
    tabbedOutput(Map("a" -> "b", "boom" -> "well", "maybe not" -> "tak")) should be(
      """a         | b
        |boom      | well
        |maybe not | tak""".stripMargin
    )
  }
}
