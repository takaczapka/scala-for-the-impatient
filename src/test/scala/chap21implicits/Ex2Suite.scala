package chap21implicits

import org.scalatest.{Matchers, FunSuite}

class Ex2Suite extends FunSuite with Matchers {

  import Ex2.PercInt

  test("percentage operator") {

    120 +% 10 should be(132)
    0 +% 12 should be(0)
    100 +% 100 should be(200)
    100 +% 200 should be(300)
  }
}
