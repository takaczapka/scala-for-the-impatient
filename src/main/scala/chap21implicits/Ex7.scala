package chap21implicits

import java.awt.Point

/**
  * 7. Continue the previous exercise, comparing two points according to their distance to the origin. How can you
  * switch between the two orderings?
  */
object Ex7 {

  implicit class RichPoint(p: Point) extends Ordered[Point] {

    def distanceFromOrigin: Double = math.sqrt(p.x * p.x + p.y * p.y)

    override def compare(that: Point): Int =
      p.distanceFromOrigin.compare(that.distanceFromOrigin)
  }

  // Other options
  //
  // * Implicit object
  //  implicit object POrdering extends  Ordering[Point] {
  //    override def compare(x: Point, y: Point): Int = -1
  //  }
  //
  // * implicit conversion to Ordered[Point]
  //
  //  implicit def pointToOrderedPoint(p: Point): Ordered[Point] = new Ordered[Point] {
  //    override def compare(that: Point): Int = -1
  //  }

  // ANSWER
  // I can switch between the orderings by changing and import of implicit class conversion.
}
