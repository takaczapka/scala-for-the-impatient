package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3._

   test("fraction operations") {

     val f1 = new Fraction(15, 3)
     val f2 = new Fraction(45, 10)

     (f1 + f2).toString should be ("19/2")
     (f1 - f2).toString should be ("1/2")
     (f1 * f2).toString should be ("45/2")
     (f1 / f2).toString should be ("10/9")
   }
 }
