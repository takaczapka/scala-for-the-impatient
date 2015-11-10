package chap8inheritance

/**
 * 5. Design a class Point whose x and y coordinate values can be provided in a constructor.
 * Provide a subclass LabeledPoint whose constructor takes a label value and x and y coordinates,
 * such as
 *
 * new LabeledPoint("Black Thursday", 1929, 230.07)
 */
object Ex5 {

  class Point(val x: Double, val y: Double)

  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y)

  new LabeledPoint("Black Thursday", 1929, 230.07)
}
