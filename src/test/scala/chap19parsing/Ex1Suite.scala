package chap19parsing

import org.scalatest.{Matchers, FunSuite}

class Ex1Suite extends FunSuite with Matchers {

  import Ex1._

  val parser = new ExprParser()

  def calculate(expr: String) = parser.parse(parser.expr, expr).get

  test("handles positive and negative numbers") {
    calculate("1") should be (1)
    calculate("-1") should be (-1)
  }

  test("various expressions") {

    calculate("1") should be (1)
    calculate("2 - 2") should be (0)
    calculate("-2 + 2 + -2 + 2") should be (0)
    calculate("2 * 3") should be (6)
    calculate("2 + 5 * 3 - 1") should be (16)
    calculate("6 / (1 * 2) * 3 % 2") should be (1)
  }
}
