package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex10Suite extends FunSuite with Matchers {

  import Ex10.RichFile

  test("Extract some paths") {

    val RichFile(a, b, c) = "some/path/file423.txt"

    Seq(a, b, c) should be(Seq("some", "path", "file423.txt"))

    // Interesting matching usage
    //    "some/path/file423.txt" match {
    //      case RichFile(s) => println(s)
    //      case RichFile(s, "path") => println(s)
    //      case RichFile(s, "path", f) => println(f) // matches this one
    //      case _ => println("nothing")
    //    }
  }

}
