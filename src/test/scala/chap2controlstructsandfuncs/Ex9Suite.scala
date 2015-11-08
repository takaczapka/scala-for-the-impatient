package chap2controlstructsandfuncs

import org.scalatest.FunSuite

class Ex9Suite extends FunSuite with UnicodeProductBehavior {

   override def product(s: String): Long = Ex9.product(s)
 }
