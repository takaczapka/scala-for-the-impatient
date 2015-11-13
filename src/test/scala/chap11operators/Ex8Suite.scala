package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

  import Ex8._


  test("Bit setting") {
    val m1 = new Matrix(Array(
      Array(1, 2, 3),
      Array(7, 8, 9)
    ))

    val m2 = new Matrix(Array(
      Array(5, 6, 7),
      Array(3, 4, 5)
    ))

    (m1 + m2) should be(new Matrix(Array(
      Array(6, 8, 10),
      Array(10, 12, 14))))
  }

  test("matrix product") {

    val m1 = new Matrix(Array(
      Array(0, 1, 2),
      Array(3, 4, 5)
    ))

    val m2 = new Matrix(Array(
      Array(6, 7),
      Array(8, 9),
      Array(10, 11)
    ))

    (m1 * m2) should be(Matrix(Array(
      Array(28, 31),
      Array(100, 112)
    )))
  }

  test("matrix product with a scalar") {

    val m = new Matrix(Array(
      Array(0, 1, 2),
      Array(3, 4, 5)
    ))


    (m * 5) should be(Matrix(Array(
      Array(0, 5, 10),
      Array(15, 20, 25)
    )))
  }
}
