package chap21implicits

import java.awt.Point

/**
  * 6. Compare objects of the class java.awt.Point by lexicographic comparison.
  */
object Ex6 {

  implicit class RichPoint(p: Point) extends Ordered[Point] {
    override def compare(that: Point): Int = {
      val r = p.x - that.x
      if (r == 0) p.y - that.y
      else r
    }
  }
}
