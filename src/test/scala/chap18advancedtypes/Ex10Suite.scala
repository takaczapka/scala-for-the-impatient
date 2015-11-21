package chap18advancedtypes

import org.scalatest.{FunSuite, Matchers}

class Ex10Suite extends FunSuite with Matchers {

  test("mixing self types with wrong precedence leads to trouble") {

    trait A {
      val a = 10
    }

    trait B {
      this: A =>

      val b = a
    }

    trait C {
      this: B =>
    }

    val c1 = new C with A with B
    val c2 = new C with B with A

    c1.b should be(10)
    c2.b should be(0)
  }
}
