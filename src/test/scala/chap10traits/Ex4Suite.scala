package chap10traits

import chap10traits.Ex4.{CryptoLogger, PrintLogger}
import org.scalatest.{FunSuite, Matchers}

class Ex4Suite extends FunSuite with Matchers {

  import Ex4.CesarCipher.encode

  test("Cesar cipher is reversible") {
    encode("abc", 3) should be("def")

    val s = "My pony is over the ocean"
    encode(encode(s, 3), -3) should be(s)
  }

  test("logger mixins examples") {

    val logger1 = new CryptoLogger with PrintLogger {
      val shift = 3
    }
    logger1.log("Maciej Falski, takaczapka@gmail.com")

    val logger2 = new PrintLogger with CryptoLogger {
      val shift = 3
    }
    logger2.log("Maciej Falski, takaczapka@gmail.com")
  }

  test("traits and type hierarchy initialization sequence") {

    class C1 {
      def m: List[String] = List("C1")
    }

    trait T1 extends C1 {
      override def m: List[String] = {
        "T1" :: super.m
      }
    }

    trait T2 extends C1 {
      override def m: List[String] = {
        "T2" :: super.m
      }
    }

    trait T3 extends C1 {
      override def m: List[String] = {
        "T3" :: super.m
      }
    }

    (new T1 with T2 with T3).m should be(List("T3", "T2", "T1", "C1"))

    (new T2 with T1 with T3).m should be(List("T3", "T1", "T2", "C1"))

    new T2 {
      override def m: List[String] = {
        "C2" :: super.m
      }
    }.m should be(List("C2", "T2", "C1"))

    new T2 {}.m should be(List("T2", "C1"))

    (new T2 with T1).m should be(List("T1", "T2", "C1"))

    new T1 with T2 with T3 {
      override def m: List[String] = {
        "C2" :: super.m
      }
    }.m should be(List("C2", "T3", "T2", "T1", "C1"))
  }
}
