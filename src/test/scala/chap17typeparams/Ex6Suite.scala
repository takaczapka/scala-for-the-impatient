package chap17typeparams

import org.scalatest.{Matchers, FunSuite}

class Ex6Suite extends FunSuite with Matchers {

  import Ex6.middle

  test("middle") {

    middle(Seq(1, 2, 23)) should be (2)
    middle(Seq(1, 2, 23, 21, 1, 22, 52)) should be (21)
    middle(List(1, 2, 23)) should be (2)
    middle(List(9)) should be (9)
    middle(Array(6, 6, 6)) should be (6)
  }
}
