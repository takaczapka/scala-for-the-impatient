package chap10traits

import java.awt.Point

import org.scalatest.{FunSuite, Matchers}

class Ex2Suite extends FunSuite with Matchers {

  import Ex2.OrderedPoint

  test("ordering of points is correct") {

    assert(OrderedPoint(1, 1) < OrderedPoint(1, 2))
    assert(OrderedPoint(1, 1) < new Point(1, 2))

    // implicit conversion between Point and OrderedPoint let us compare on plain points
    implicit def pointToOrderedPoint(p: Point): OrderedPoint = new OrderedPoint(p.x, p.y)

    assert(new Point(1, 1) < new Point(1, 2))

    // to get ScalaTest matchers going we actually need an way to convert OrderPoint to Comparable[OrderPoint],
    // OrderedPoint extends Comparable[Point] not Comparable[OrderedPoint]
    implicit def orderedPointToComparable(p: OrderedPoint): Comparable[OrderedPoint] = new Comparable[OrderedPoint] {
      override def compareTo(o: OrderedPoint): Int = p.compare(o)
    }

    OrderedPoint(1, 1) should be < OrderedPoint(1, 2)
    OrderedPoint(1, 1) should be < OrderedPoint(2, 2)
    OrderedPoint(1, 1) should be < OrderedPoint(2, 1)

    OrderedPoint(2, 2) shouldNot be < OrderedPoint(2, 2)
    OrderedPoint(2, 2) shouldNot be < OrderedPoint(1, 2)
    OrderedPoint(2, 2) shouldNot be < OrderedPoint(2, 1)
  }
}
