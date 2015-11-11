package chap10traits

/**
 * 1. The java.awt.Rectangle class has useful methods translate and grow that are unfortunately absent from
 * classes such as java.awt.geom.Ellipse2D. In Scala, you can fix this problem. Define a trait RectangleLike
 * with concrete methods translate and grow. Provide any abstract methods that you need for the implementation,
 * so that you can mix in the trait like this:
 *
 * val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
 * egg.translate( 10, -10)
 * egg.grow( 10, 20)
 */
object Ex1 {

  trait RectangleLike {

    def getX: Double

    def getY: Double

    def getWidth: Double

    def getHeight: Double

    def setFrame(x: Double, y: Double, w: Double, h: Double)

    def translate(x: Int, y: Int): Unit = setFrame(x, y, getWidth, getHeight)

    def grow(h: Int, v: Int): Unit = setFrame(getX, getY, v, h)
  }

  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike

  egg.translate(1, 2)
  egg.grow(2, 2)
}
