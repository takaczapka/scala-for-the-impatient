package chap18advancedtypes

import org.scalatest.{FunSuite, Matchers}

class Ex1Suite extends FunSuite with Matchers {

  import Ex1.Bug

  test("Initial position is 0") {
    val bug = new Bug
    bug.position should be(0)
  }

  test("moving n steps, turning, and moving n steps brings to position 0") {
    val bug = new Bug
    bug.move(10).turn().move(10)
    bug.position should be(0)
  }

  test("more random moves ") {
    val bug = new Bug
    bug.move(4)
    bug.position should be(4)
    bug.move(6)
    bug.position should be(10)
    bug.turn()
    bug.position should be(10)
    bug.move(6)
    bug.position should be(4)
  }
}
