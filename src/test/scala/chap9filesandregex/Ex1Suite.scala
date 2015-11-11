package chap9filesandregex

import helpers.FileHelpers
import org.scalatest.{Matchers, FunSuite}

import FileHelpers._
import scala.io.Source

class Ex1Suite extends FunSuite with Matchers {

  import Ex1._

  test("reverses the order of lines in the file") {

    val lines = Seq("one", "two", "three")

    val file = createTempFile(lines.mkString("\n"))

    reverseFileLines(file)

    Source.fromFile(file).getLines().toSeq.reverse should be (lines)
  }
}
