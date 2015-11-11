package chap10traits

import java.awt.Point

/**
 * 2. Define a class OrderedPoint by mixing scala.math.Ordered[ Point] into java.awt.Point.
 * Use lexicographic ordering, i.e. (x, y) < (x’, y’)
 */
object Ex2 {

  object OrderedPoint {
    def apply(x: Int, y: Int) = new OrderedPoint(x, y)
  }

  class OrderedPoint(x: Int, y: Int) extends java.awt.Point(x, y) with scala.math.Ordered[Point] {

    def compare(that: Point): Int = {
      if (this.getX < that.getX || (this.getX == that.getX && this.getY < that.getY)) -1
      else if (this.getX == that.getX && this.getY == that.getY) 0
      else 1
    }
  }

}
