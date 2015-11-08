package chap4maps

import org.scalatest.FunSuite

class Ex3Suite extends FunSuite with FrequencyBehavior {

  override def frequency(s: Seq[String]): Map[String, Int] = Ex3.frequency(s)
}
