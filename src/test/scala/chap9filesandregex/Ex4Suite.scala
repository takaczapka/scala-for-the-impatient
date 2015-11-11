package chap9filesandregex

import helpers.FileHelpers
import FileHelpers._
import org.scalatest.{FunSuite, Matchers}

class Ex4Suite extends FunSuite with Matchers {

  import Ex4.floatingResults

  test("finds all floats and produces a report") {

    val lines = Seq("this is it: 1.212",
      "let's have 2",
      "add 6.213 to it",
      "and divide by 2.1",
      "1.14 and call for help 79 258 606 59")

    val file = createTempFile(lines.mkString("\n"))

    floatingResults(file) should be(
      (1014.66504f, 112.74056f, 606.0f, 1.14f))
  }
}
