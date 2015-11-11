package chap9filesandregex

import chap9filesandregex.FileHelpers._
import org.scalatest.{FunSuite, Matchers}

import scala.io.Source

class Ex5Suite extends FunSuite with Matchers {

  import Ex5.powOf2

  test("finds all floats and produces a report") {

    val expectedFirst5Lines = Seq(
      "      1     1.0",
      "      2     0.5",
      "      4     0.25",
      "      8     0.125",
      "     16     0.0625")

    val file = createTempFile()

    powOf2(file)

    Source.fromFile(file).getLines().take(5).toSeq should be (expectedFirst5Lines)
  }
}
