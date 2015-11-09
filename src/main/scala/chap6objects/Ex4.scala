package chap6objects

/**
 * 4. Define a Point class with a companion object so that you can construct Point instances as Point( 3, 4),
 * without using new.
 */
object Ex4 {

  class Point(x: Int, y: Int)

  object Point {
    def apply(x: Int, y: Int) = new Point(x, y)
  }

  val p = Point(3, 4)
}
