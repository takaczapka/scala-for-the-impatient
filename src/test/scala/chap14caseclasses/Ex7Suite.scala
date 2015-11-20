package chap14caseclasses

import org.scalatest.{FunSuite, Matchers}

class Ex7Suite extends FunSuite with Matchers {

  import Ex7._

  test("sum of a one leaf tree is value of that element") {
    sum(Leaf(5)) should be (5)
  }

  test("sum all elements of the list and sublists") {
    sum(Node(Node(Node(Leaf(3), Leaf(8), Leaf(2))), Node(Leaf(5), Leaf(2)))) should be (20)
  }
}
