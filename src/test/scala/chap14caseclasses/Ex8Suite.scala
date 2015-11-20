package chap14caseclasses

import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

  import Ex8._

  test("some tree with operators tests") {

    sum(Node('-', Leaf(3), Leaf(8))) should be(-5)
    sum(Node('+', Node('*', Node('-', Leaf(3), Leaf(8)), Leaf(2)), Leaf(19))) should be(9)
  }
}