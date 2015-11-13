package chap12higherorderfunc

import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

   test("providing my function to array corresponds function ") {
     val a = Array("I", "am", "here")
     val a1 = Array("just", "breathe", "my", "friend")
     val b = Array(1, 2, 4)

     a.corresponds(b)((a, b) => a.length == b) should be (true)
     a1.corresponds(b)((a, b) => a.length == b) should be (false)
   }
 }
