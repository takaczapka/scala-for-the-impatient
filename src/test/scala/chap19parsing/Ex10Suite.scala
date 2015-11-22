package chap19parsing

import org.scalatest.{FunSuite, Matchers}

class Ex10Suite extends FunSuite with Matchers {

  import Ex10._

  val parser = new ExprParser()

  def run(program: String): Option[Int] = {
    val result = parser.parseAll(parser.application, program)

    if (result.successful) result.get.run()
    else throw new RuntimeException("Failed to run: " + result)
  }

  test("empty main body is a legal construct") {
    run("main {}") should be(None)
  }

  test("assignment cancels last return instruction") {
    run("main { 2 + 2; a = 1 + 1; }") should be(None)
  }

  test("basic arithmetic operations and var assignments") {
    run(
      """main {
        |  a = 1 + 2;
        |  out = a;
        |  out = 2 * 4;
        |  b = a / 3;
        |  out = b + 2;
        |  out = 21 / 7;
        |  out = b % 2;
        |  b;
        |}""".stripMargin) should be(Some(1))
  }

  test("if else statements") {
    run("main { if (1 > 2) { 1; } else { 2; } }") should be(Some(2))
    run("main { if (1 >= 2) { 1; } else { 2; } }") should be(Some(2))
    run("main { if (1 == 2) { 1; } else { 2; } }") should be(Some(2))
    run("main { if (1 <= 2) { 1; } else { 2; } }") should be(Some(1))
    run("main { if (1 < 2) { 1; } else { 2; } }") should be(Some(1))
    run("main { if (1 == 1) { 1; } else { 2; } }") should be(Some(1))
  }

  test("last statement in code block is its result)") {
    run("main { 2 + 2; 1 + 5 * 2; }") should be(Some(11))
  }

  test("functions return values") {
    run("func one() { out = 1; 2; } main { one() + 2 + one(); }") should be(Some(6))
  }


  test("while statement") {
    run(
      """main {
        |  i = 5;
        |  while (i >= 3) {
        |    out = i;
        |    i = i - 1;
        |  }
        |  i;
        |}""".stripMargin) should be(Some(2))

    run(
      """main {
        |  while (1 >= 3) {
        |    out = i;
        |  }
        |}""".stripMargin) should be(None)
  }

  test("more examples") {
    run("main { a = 2 + 2 - 2; b = 4 + 1 * 2 ^ a; b + a; } ") should be(Some(10))
    run(
      """
        | func one() {
        |   out = 11111111;
        |   1;
        | }
        | func two() {
        |   out = 22222222;
        |   2;
        | }
        | main {
        |   a = 2 + 2 - 2 + one();
        |   if (3 == a) {
        |     c = 3;
        |     out = 6666; out = 2121;
        |     if (1 == 1) {
        |       out = 223;
        |     }
        |   } else {
        |     out=77777;
        |   }
        |   b = (-4) - (-1) * 2 ^ a;
        |   out = b + a;
        |   out = 21;
        |   out = c;
        |   i = 10;
        |   while (i > 3) {
        |     out = i; i = i - 1;
        |   }
        |   out = 1111111;
        | }
        | """.stripMargin) should be(None)
  }
}
