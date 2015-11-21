package chap16xml

import org.scalatest.{Matchers, FunSuite}

import scala.xml.Text
import scala.xml.Atom

class Ex3Suite extends FunSuite with Matchers {

  test("match on plain text node") {
    (<li>Fred</li> match {
      case <li>{Text(t)}</li> => t
    }) should be("Fred")
  }

  test("match on generated text node, take 1") {

    (<li>{"Fred"}</li> match {
      case <li>{t}</li> => t.text
    }) should be("Fred")

    // <li>{"Fred"}</li> is of node type Atom[String] and it doesn't match on <li>{Text(t){</li>
    // Atom doesn't have companion object with extractor
  }

  test("match on generated text node, take 2") {

    (<li>{"Fred"}</li>.child.head match {
      case t: Atom[Text] => t.text
    }) should be("Fred")
  }
}

