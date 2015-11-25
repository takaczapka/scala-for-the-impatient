package chap21implicits

import chap11operators.Ex3.Fraction
import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5._

  test("smaller fraction") {

    smaller(Fraction(1, 1), Fraction(2, 2)) should be (Fraction(1, 1))
    smaller(Fraction(1, 2), Fraction(1, 3)) should be (Fraction(1, 3))
    smaller(Fraction(3, 1), Fraction(2, 1)) should be (Fraction(2, 1))
    smaller(Fraction(1, 7), Fraction(2, 5)) should be (Fraction(1, 7))
  }
}
