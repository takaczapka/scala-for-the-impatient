package chap21implicits

import chap11operators.Ex3.Fraction

/**
  * 5. Provide the machinery that is needed to compute
  *
  * smaller(Fraction(1, 7), Fraction(2, 9))
  *
  * in Section 21.6, “Implicit Conversions with Implicit Parameters,” on page 310. Supply a class RichFraction
  * that extends Ordered[Fraction].
  */
object Ex5 {

  implicit class RichFraction(f: Fraction) extends Ordered[Fraction] {
    override def compare(that: Fraction): Int =
      f.num * f.den * that.den - that.num * f.den * that.den
  }

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) =
    if (order(a) < b) a else b
}
