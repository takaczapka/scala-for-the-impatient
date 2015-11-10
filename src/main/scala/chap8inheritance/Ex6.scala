package chap8inheritance

/**
 * 6. Define an abstract class Shape with an abstract method centerPoint and subclasses Rectangle and Circle.
 * Provide appropriate constructors for the subclasses and override the centerPoint method in each subclass.
 */
object Ex6 {

  import Ex5.Point

  abstract class Shape {
    def centerPoint: Point
  }

  class Rectangle(cornerPoint: Point, width: Double) extends Shape {
    def centerPoint: Point = new Point(cornerPoint.x + width / 2, cornerPoint.y + width / 2)
  }

  class Circle(val centerPoint: Point, radius: Double) extends Shape

}
