package chap12higherorderfunc

import org.scalatest.{FunSuite, Matchers}

class Ex7Suite extends FunSuite with Matchers {

  import Ex7.adjustToPair

   test("test adjusting tuple to pair") {

     adjustToPair(_ * _)((6, 7)) should be (42)

     val pairs = (1 to 5) zip (11 to 15)
     pairs.map(adjustToPair(_ + _)) should be (Seq(12, 14, 16, 18, 20))
   }
 }
