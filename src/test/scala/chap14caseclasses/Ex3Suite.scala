package chap14caseclasses

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3.swapInArr

  test("swap in empty or 1-element array does nothing") {

    swapInArr(Array()) should be (Array())
    swapInArr(Array(1)) should be (Array(1))
  }

  test("swap only two first elements") {

    swapInArr(Array(1, 2)) should be (Array(2, 1))
    swapInArr(Array(8, 9, 3, 4, 5)) should be (Array(9, 8, 3, 4, 5))
  }
}
