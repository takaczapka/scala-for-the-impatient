package chap16xml

import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

  import Ex8.toMap

  test("empty table generates empty map") {
    toMap(<dl></dl>) should be (Map.empty)
  }

  test("non empty map generates non empty table") {
    toMap(<dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>) should be (Map("A" -> "1", "B" -> "2"))
  }
}
