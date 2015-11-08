package chap2controlstructsandfuncs

import org.scalatest.FunSuite

class Ex2Suite extends FunSuite {

  import Ex2._

  test("Empty val block {} is of type Unit") {
    assert(block.isInstanceOf[Unit])
  }

  test("Empty block value is ()") {
    assert(block === ())
  }
}
