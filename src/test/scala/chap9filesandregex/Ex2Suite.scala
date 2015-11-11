package chap9filesandregex

import chap9filesandregex.FileHelpers._
import org.scalatest.{FunSuite, Matchers}

import scala.io.Source

class Ex2Suite extends FunSuite with Matchers {

  import Ex2.replaceTabs

  test("replaces tabs with spaces") {

    val lines = Seq("one\t", "tw\to", "\tthree")
    val expectedLines = Seq("one    ", "tw    o", "    three")

    val file = createTempFile(lines.mkString("\n"))

    replaceTabs(file, 4)

    Source.fromFile(file).getLines().toSeq should be (expectedLines)
  }
}
