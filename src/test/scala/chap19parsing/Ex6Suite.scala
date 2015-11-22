package chap19parsing

import org.scalatest.{FunSuite, Matchers}

class Ex6Suite extends FunSuite with Matchers {

  import Ex6._
  
  val parser = new ExprParser() 
  
  def parse(s: String): Expr = {
    parser.parse(parser.expr, s).get
  }

  test("evaluation precedence") {
    parse("1") should be (Number(1))
    parse("2 - 2") should be (Operator("-", Number(2), Number(2)))
    parse("2 - 3 - 4") should be (Operator("-", Operator("-", Number(2), Number(3)), Number(4)))
    parse("2 + 3") should be (Operator("+", Number(2), Number(3)))
    parse("-2 + 2 + -2 + 2") should be (Operator("+", Operator("+", Operator("+", Number(-2), Number(2)), Number(-2)), Number(2)))
    parse("2 * 3") should be (Operator("*", Number(2), Number(3)))
    parse("2 + 5 * 3 - 1") should be (Operator("-", Operator("+", Number(2), Operator("*", Number(5), Number(3))), Number(1)))
  }
}
