package chap9filesandregex

import helpers.FileHelpers
import FileHelpers._
import org.scalatest.{FunSuite, Matchers}

import scala.io.Source

class Ex3Suite extends FunSuite with Matchers {

  import Ex3.findOnlyLongerThan3CharWords

  test("replaces tabs with spaces") {

    val lines = Seq("one carrot", "commando pablo", "the best")
    val expectedWords = Seq("carrot", "commando", "pablo", "best")

    val file = createTempFile(lines.mkString("\n"))

    findOnlyLongerThan3CharWords(file).toSeq should be (expectedWords)
  }
}
