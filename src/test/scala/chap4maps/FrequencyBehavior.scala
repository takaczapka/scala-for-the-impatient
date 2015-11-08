package chap4maps

import org.scalatest.{Matchers, FunSuite}

trait FrequencyBehavior extends Matchers {
  this: FunSuite =>

  def frequency(s: Seq[String]): Map[String, Int]

  test("empty sequence of words produces empty frequency map") {
    frequency(Seq.empty) should be(Map[String, Int]())
  }

  test("creates a correct frequency map for seq of words") {
    frequency(Seq("one", "two")) should be(Map[String, Int]("one" -> 1, "two" -> 1))
    frequency(Seq("one", "two", "one")) should be(Map[String, Int]("one" -> 2, "two" -> 1))
  }
}
