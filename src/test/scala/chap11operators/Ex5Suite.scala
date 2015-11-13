package chap11operators

import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5.Table

  test("Empty html table can be created") {

    assert(new Table().toString ===  "<table><tr></tr></table>")
  }

  test("Filled up table easily constructed") {
    val t = new Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM,.NET"

    assert(t.toString === "<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling</td>" +
      "<td>Odersky</td></tr><tr><td>JVM</td><td>JVM,.NET</td></tr></table>")
  }
}
