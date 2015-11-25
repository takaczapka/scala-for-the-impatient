package chap11operators

import scala.math._

/**
 * 3. Implement the Fraction class with operations + - * /. Normalize fractions, for example turning 15/– 6 into –5/ 3.
 * Divide by the greatest common divisor, like this: ...
 */
object Ex3 {

  object Fraction {
    def apply(n: Int, d: Int) = new Fraction(n, d)
  }

  class Fraction(n: Int, d: Int) {
    val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)

    val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

    override def toString = num + "/" + den

    override def hashCode(): Int = num * 7 + den * 13

    override def equals(obj: scala.Any): Boolean = obj match {
      case t: Fraction => num == t.num && den == t.den
      case _ => false
    }

    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

    def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

    def +(that: Fraction): Fraction = {
      new Fraction(this.num * that.den + that.num * this.den, this.den * that.den)
    }

    def -(that: Fraction): Fraction = {
      this + new Fraction(-that.num, that.den)
    }

    def *(that: Fraction): Fraction = {
      new Fraction(this.num * that.num, this.den * that.den)
    }

    def /(that: Fraction): Fraction = {
      new Fraction(this.num * that.den, that.num * this.den)
    }
  }

}
