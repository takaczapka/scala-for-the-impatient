package chap14caseclasses

import org.scalatest.{FunSuite, Matchers}

class Ex9Suite extends FunSuite with Matchers {

  import Ex9.sum

  test("sum") {
    sum(Nil) should be (0)
    sum(List(None)) should be (0)
    sum(List(Some(0))) should be (0)
    sum(List(None, Some(1), Some(2), None, Some(3))) should be (6)
  }
}
