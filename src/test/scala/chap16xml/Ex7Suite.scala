package chap16xml

import org.scalatest.{FunSuite, Matchers}

import scala.xml.XML

class Ex7Suite extends FunSuite with Matchers {

  import Ex7.toTable

  test("empty map generates empty table") {
    toTable(Map.empty) should be (<dl></dl>)
  }

  test("non empty map generates non empty table") {
    toTable(Map("A" -> "1", "B" -> "2")) should be (<dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>)
  }
}
