package chap18advancedtypes

/**
  * 9. Consider this class that models a physical dimension:
  *
  * abstract class Dim[T]( val value: Double, val name: String) {
  * protected def create create(v: Double): T
  * def +(other: Dim[ T]) = create( value + other.value)
  * override def toString() = value + " " + name
  * }
  *
  * Here is a concrete subclass:
  *
  * class Seconds(v: Double) extends Dim[Seconds](v, "s") {
  * override def create(v: Double) = new Seconds(v)
  * }
  *
  * But now a knucklehead could define
  *
  * class Meters(v: Double) extends Dim[Seconds](v, "m") {
  * override def create( v: Double) = new Seconds(new Seconds(v)
  * }
  *
  * But now a knucklehead could define
  *
  * class Meters(v: Double) extends Dim[Seconds](v, "m") {
  * override def create(v: Double) = new Seconds(v)
  * }
  *
  * allowing meters and seconds to be added. Use a self type to prevent that.
  */
object Ex9 {

  abstract class Dim[T](val value: Double, val name: String) {
    this: T =>

    protected def create(v: Double): T

    def +(other: Dim[T]) = create(value + other.value)

    override def toString = value + " " + name
  }

  class Seconds(v: Double) extends Dim[Seconds](v, "s") {
    override def create(v: Double) = new Seconds(v)
  }

  class Meters(v: Double) extends Dim[Meters](v, "m") {
    override def create(v: Double) = new Meters(v)
  }

  val seconds = new Seconds(12)
  val meters = new Meters(33)

  seconds + new Seconds(343)

  // illegal - will not compile
  // meters + new Seconds(2)
  meters + new Meters(2)
}
