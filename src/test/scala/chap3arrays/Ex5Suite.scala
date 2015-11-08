package chap3arrays

import generators.Generators._
import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5.avg

  test("avg of single element array is value of the element") {
    val i = anyNumber
    avg(Array(i)) should be (i +- 0.001)
  }

  test("avg of array with the same elements is value of any element") {
    val i = anyNumber
    avg(Array(i, i, i)) should be (i +- 0.001)
  }

  test("avg examples") {
    avg(Array(1, 3)) should be (2.0)
    avg(Array(1, 3, 5)) should be (3.0)
    avg(Array(1, 2)) should be (1.5)
    avg(Array(1, 2)) should be (1.5)
  }

}
