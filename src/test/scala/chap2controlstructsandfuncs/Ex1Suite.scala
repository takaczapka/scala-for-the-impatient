package chap2controlstructsandfuncs

import generators.Generators._
import org.scalatest.FunSuite

class Ex1Suite extends FunSuite {

  import Ex1.signum

  test("signum gives -1 for number lower than 0") {
    assert(signum(anyNegativeInt) === -1)
  }

  test("signum gives 0 for number == 0") {
    assert(signum(0) === 0)
  }

  test("signum gives 1 for number greater than 0") {
    assert(signum(anyPositiveInt) === 1)
  }
}
