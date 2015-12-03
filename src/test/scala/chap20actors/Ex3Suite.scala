package chap20actors

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  val dir = getClass.getResource("/chap20actors/poems").getFile

  test("Finds correct amount words") {
    Ex3.countRegexMatches(dir, "(?i:you)".r) should be (6)
    Ex3.countRegexMatches(dir, "and".r) should be (26)
    Ex3.countRegexMatches(dir, "(?i:tyger)".r) should be (4)
  }

  test("returns 0 if no matches found") {
    val pattern = "this can't be there".r
    Ex3.countRegexMatches(dir, pattern) should be (0)
  }
}
