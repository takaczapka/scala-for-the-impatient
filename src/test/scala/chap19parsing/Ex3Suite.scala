package chap19parsing

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3._

  val parser = new IntParser()

  def parse(expr: String) = parser.parse(parser.expr, expr).get

  test("parse int lists") {

    parse("()") should be(List.empty)
    parse("(1)") should be(List(1))
    parse("(1     )") should be(List(1))
    parse("(1     ,2)") should be(List(1, 2))
    parse("(   1     ,   2   )") should be(List(1, 2))
    parse("(1,2,3,-4,3)") should be(List(1, 2, 3, -4, 3))
  }
}
