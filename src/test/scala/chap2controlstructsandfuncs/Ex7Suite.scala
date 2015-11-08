package chap2controlstructsandfuncs

import org.scalatest.FunSuite

class Ex7Suite extends FunSuite with UnicodeProductBehavior {

   override def product(s: String): Long = Ex7.product(s)
 }
