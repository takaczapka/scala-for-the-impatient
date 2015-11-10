package chap8inheritance

import java.awt.Point

/**
 * 7. Provide a class Square that extends java.awt.Rectangle and has three constructors: one that constructs a square
 * with a given corner point and width, one that constructs a square with corner (0, 0) and a given width,
 * and one that constructs a square with corner (0, 0) and width 0.
 */
object Ex7 {

  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {

    def this(p: Point) {
      this(p.x, p.y, 0)
    }

    def this(width: Int) {
      this(0, 0, width)
    }
  }

}
