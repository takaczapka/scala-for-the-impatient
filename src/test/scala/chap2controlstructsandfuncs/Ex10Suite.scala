package chap2controlstructsandfuncs

import generators.Generators._
import org.scalatest.FunSuite

class Ex10Suite extends FunSuite {

  import Ex10.pow

  test("any number pow 0 is 1") {
    assert(pow(anyNumber, 0) === 1)
  }

  test("powers of 2") {
    assert(pow(2, -3) === 0.125)
    assert(pow(2, -2) === 0.25)
    assert(pow(2, -1) === 0.5)
    assert(pow(2, 0) === 1)
    assert(pow(2, 1) === 2)
    assert(pow(2, 2) === 4)
    assert(pow(2, 3) === 8)
    assert(pow(2, 10) === 1024)
  }

  test("other powers") {
    assert(pow(5, -3) === 0.008)
    assert(pow(2.5, 12) === 59604.644775390625)
  }

}
