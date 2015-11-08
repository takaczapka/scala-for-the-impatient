package chap2controlstructsandfuncs

import org.scalatest.FunSuite

class Ex6Suite extends FunSuite with UnicodeProductBehavior {

  override def product(s: String): Long = Ex6.product(s)
}
