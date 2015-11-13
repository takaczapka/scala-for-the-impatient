package chap11operators

import scala.math._

/**
 * 4. Implement a class Money with fields for dollars and cents. Supply +, - operators as well as comparison
 * operators == and <. For example, Money( 1, 75) + Money( 0, 50) = = Money( 2, 25) should be true.
 * Should you also supply * and / operators? Why or why not?
 */
object Ex4 {

  case class Money(_major: Int, _minor: Int) {

    assert(_major >= 0 && _minor >= 0, "Money can't be negative")

    val major = _major + _minor / 100
    val minor = _minor % 100

    implicit def toMoney(d: Double): Money = {
      new Money(d.toInt, abs((d * 100).toInt % 100))
    }

    def toDouble: Double = major + (minor / 100.0)

    def +(that: Money): Money = this.toDouble + that.toDouble

    def -(that: Money): Money = this.toDouble - that.toDouble

    def ==(that: Money): Boolean = this.major == that.major && this.minor == that.minor

    def <(that: Money): Boolean =
      this.major < that.major || this.major == that.major && this.minor < that.minor

    override def toString = major + "." + minor
  }

}
