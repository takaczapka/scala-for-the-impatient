package chap12higherorderfunc

import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5.largest

   test("largest in the scope") {

     val f = (x: Int) => 10 * x - x * x
     largest(f, 1 to 10) should be (25)

     largest(x => x, 1 to 10) should be (10)

     largest(x => -x, 1 to 10) should be (-1)
   }
 }
