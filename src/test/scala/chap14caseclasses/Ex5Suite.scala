package chap14caseclasses

import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5._

  test("sum of empty list is zero") {
    sum(Nil) should be (0)
  }

  test("sum of one element list is value of that element") {
    sum(List(5)) should be (5)
  }

  test("sum all elements of the list and sublists") {
    sum(List(List(3, List(8)), 2, List(5))) should be (18)
  }
}
