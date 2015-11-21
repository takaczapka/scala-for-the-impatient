package chap16xml

import org.scalatest.{FunSuite, Matchers}

import scala.xml.XML

class Ex6Suite extends FunSuite with Matchers {

  test("find all hrefs with descriptions in html") {
    val xml = XML.loadFile("src/test/resources/chap16xml/test.html")

    val hrefsWithDescription = (xml \\ "a").map(n => (n.attribute("href").map(_.text).getOrElse("NO HREF"), n.text))

    hrefsWithDescription should be(Seq("link1" -> "text1", "link2" -> "text2"))
  }
}
