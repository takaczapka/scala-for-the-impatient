package chap16xml

import java.io.File

import org.scalatest.{FunSuite, Matchers}

import scala.xml.parsing.ConstructingParser
import scala.xml.{Document, Node, XML}

class Ex10Suite extends FunSuite with Matchers {

  test("read and write back preserving all the content") {

    val src = "src/test/resources/chap16xml/test.html"
    val destination = "target/test-modified.html"

    val parser = ConstructingParser.fromFile(new File(src), preserveWS = true)
    val doc: Document = parser.document()
    val root: Node = doc.docElem

    XML.save(destination, root, enc = "UTF-8")

    XML.loadFile(src) should be (XML.loadFile(destination))
  }
}
