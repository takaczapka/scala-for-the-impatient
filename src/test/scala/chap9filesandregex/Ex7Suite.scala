package chap9filesandregex

import chap9filesandregex.FileHelpers._
import org.scalatest.{FunSuite, Matchers}

import scala.io.Source

class Ex7Suite extends FunSuite with Matchers {

  import Ex7.findAllNoFloatingPointItems

  test("finds all no floating point items") {

    val lines = Seq("one1.212",
      "two2three",
      "four6.213")

    val expectedItems = Seq("one", "two", "three", "four")

    val file = createTempFile(lines.mkString("\n"))

    findAllNoFloatingPointItems(file).toSeq should be (expectedItems)
  }
}
