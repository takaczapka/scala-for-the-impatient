package chap3arrays

import generators.Generators._
import org.scalatest.{Matchers, FunSuite}

class Ex1Suite extends FunSuite with Matchers {

  import Ex1._

  test("generated array has only values between 0 (inclusive) and n (exclusive)") {

    val n = anyInt
    val a: Array[Int] = randomArray(n)

    withClue("Array's [" + a.mkString(",") + "] element") {
      for (e <- a) {
        e should be >= 0
        e should be <= n
      }
    }
  }
}
