package chap12higherorderfunc

import org.scalatest.{FunSuite, Matchers}

class Ex10Suite extends FunSuite with Matchers {

  import Ex10._

  test("unless loop") {

    var i = 10
    var result = 0
    unless(i <= 0) {
      result += 1
      i -= 1
    }

    result should be(10)
  }

  test("unless loop without currying") {

    var i = 10
    var result = 0
    unlessWithoutCurrying(i <= 0, {
      result += 1
      i -= 1
    })

    result should be(10)
  }

}
