package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex9Suite extends FunSuite with Matchers {

  import Ex9.RichFile

  test("Extract some paths") {

    val RichFile(f, d, e) = "some/path/file423.txt"

    f should be("some/path")
    d should be("file423")
    e should be("txt")

    // Another interesting usage
    //    "some/path/file423.txt" match {
    //      case RichFile(a, b, c) => println(a + " " + b + " " + c)
    //      case _ => println("not matched")
    //    }
  }

}
