package chap4maps

import org.scalatest.FunSuite

class Ex4Suite extends FunSuite with FrequencyBehavior {

  override def frequency(s: Seq[String]): Map[String, Int] = Ex4.frequency(s)

  test("frequency results are sorted by word order") {
    frequency(Seq("one", "two", "one", "three", "one")).toSeq should be(Seq("one" -> 3, "three" -> 1, "two" -> 1))
  }
}
