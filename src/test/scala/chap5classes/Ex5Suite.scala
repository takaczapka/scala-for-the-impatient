package chap5classes

import org.scalatest.{FunSuite, Matchers}

class Ex5Suite extends FunSuite with Matchers {

  import Ex5._

  test("Demonstrate Scala- and Java-style accessor usage") {

    val s = new Student("Maciej", 123)

    assert(s.name == "Maciej")
    assert(s.getName == "Maciej")

    s.name = "T"
    s.setName("Tomas")

    assert(s.id == 123)
    assert(s.getId == 123)
    s.id = 456
    s.setId(678)
  }
}
