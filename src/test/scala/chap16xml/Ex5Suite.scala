package chap16xml

import org.scalatest.{FunSuite, Matchers}

import scala.xml.XML

class Ex5Suite extends FunSuite with Matchers {

  test("find all img locations in html file") {
    val xml = XML.loadFile("src/test/resources/chap16xml/test.html")

    val imgSources = (xml \\ "img").flatMap(_.attribute("src")).map(_.text)

    imgSources should be(Seq("source/1", "source/2"))
  }
}
