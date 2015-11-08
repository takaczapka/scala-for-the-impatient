package chap4maps

import org.scalatest.{FunSuite, Matchers}

import scala.collection.mutable

class Ex6Suite extends FunSuite with Matchers {

  test("demonstrate traversal follows insertion order") {
    val l = new mutable.LinkedHashMap[String, Int]
    l += "MONDAY" -> java.util.Calendar.MONDAY
    l += "TUESDAY" -> java.util.Calendar.TUESDAY
    l += "WEDNESDAY" -> java.util.Calendar.WEDNESDAY
    l += "THURSDAY" -> java.util.Calendar.THURSDAY

    l.map(_._1) should be (Seq("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"))
  }
}
