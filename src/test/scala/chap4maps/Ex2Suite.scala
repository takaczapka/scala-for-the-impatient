package chap4maps

import org.scalatest.FunSuite

class Ex2Suite extends FunSuite with FrequencyBehavior {

  override def frequency(s: Seq[String]): Map[String, Int] = Ex2.frequency(s)
}
