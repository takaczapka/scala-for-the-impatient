package chap21implicits

import java.awt.Point

import org.scalatest.{FunSuite, Matchers}


class Ex6Suite extends FunSuite with Matchers {

  import Ex6._

  test("point lex ordering") {

    (new Point(1, 1) < new Point(2, 2)) should be(true)
    (new Point(1, 2) < new Point(1, 3)) should be(true)
    (new Point(3, 1) < new Point(2, 1)) should be(false)
    (new Point(0, 1) < new Point(0, 5)) should be(true)
    (new Point(1, 7) < new Point(2, 5)) should be(true)
  }
}
