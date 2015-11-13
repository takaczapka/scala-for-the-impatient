package chap12higherorderfunc

import org.scalatest.{FunSuite, Matchers}

class Ex6Suite extends FunSuite with Matchers {

  import Ex6.largestInput


  test("largest for input in the scope") {

    val f = (x: Int) => 10 * x - x * x
    largestInput(f, 1 to 10) should be(5)

    largestInput(x => x, 1 to 10) should be(10)

    largestInput(x => -x, 1 to 10) should be(1)
  }
}
