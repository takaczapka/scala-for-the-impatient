package chap5classes

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3._

  test("earlier is before after") {
    Time(10, 23).before(Time(23, 56)) should be (right = true)
    Time(2, 23).before(Time(2, 24)) should be (right = true)
  }

  test("later is not before earlier") {
    Time(23, 56).before(Time(10, 23)) should be (right = false)
    Time(2, 24).before(Time(2, 23)) should be (right = false)
  }

  test("now is not before now") {
    Time(10, 23).before(Time(10, 23)) should be (right = false)
  }
}
