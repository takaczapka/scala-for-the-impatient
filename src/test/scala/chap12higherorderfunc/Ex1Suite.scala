package chap12higherorderfunc

import org.scalatest.{Matchers, FunSuite}

class Ex1Suite extends FunSuite with Matchers {

  import Ex1.values

  test("a few examples of function passing as an argument") {

    val expected = Seq((-2, 4), (-1, 1), (0, 0), (1, 1), (2, 4))

    values((x: Int) => x * x, -2, 2) should be(expected)
    values(x => x * x, -2, 2) should be(expected)

    def p(x: Int) = x * x
    values(p, -2, 2) should be(expected)

    val f: (Int) => Int = p
    values(f, -2, 2) should be(expected)

    def a(f: Int => Int) = f(_)
    values(a((x: Int) => x * x), -2, 2) should be(expected)
    values(a(x => x * x), -2, 2) should be(expected)
  }

  test("a few underscore examples of function passing as an argument") {

    val expected = Seq((-2, -4), (-1, -2), (0, 0), (1, 2), (2, 4))

    values(_ * 2, -2, 2) should be(expected)
    values((_: Int) * 2, -2, 2) should be(expected)
  }

}
