package chap9filesandregex

import helpers.FileHelpers
import FileHelpers._
import org.scalatest.{FunSuite, Matchers}

import scala.io.Source

class Ex6Suite extends FunSuite with Matchers {

  import Ex6.pattern

  test("finds all occurrences of pattern") {

    val lines = Seq("" +
      "like this, maybe with \\",
    """like this, maybe with \\""",
    """like this, maybe with \\\\\\\\""")

    val file = createTempFile(lines.mkString("\n"))

    val found = pattern.findAllIn(Source.fromFile(file).mkString)

    found.size should be (3)
  }
}
