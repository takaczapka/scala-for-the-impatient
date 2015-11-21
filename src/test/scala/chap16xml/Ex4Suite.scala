package chap16xml

import org.scalatest.{FunSuite, Matchers}

import scala.xml.XML

class Ex4Suite extends FunSuite with Matchers {

  test("find all img tags without alt atribute") {
    val xml = XML.loadFile("src/test/resources/chap16xml/test.html")

    val imgWithoutAlt = (xml \\ "img").filter(_.attribute("alt").isEmpty)
    imgWithoutAlt.size should be(3)
  }
}
