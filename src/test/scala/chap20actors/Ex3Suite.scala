package chap20actors

import org.scalatest.{FunSuite, Matchers}

import scala.util.Success

class Ex3Suite extends FunSuite with Matchers {

  import Ex3.countRegexMatches

  val dir = getClass.getResource("/chap20actors/poems").getFile

  test("Finds correct amount words") {
    countRegexMatches(dir, "(?i:you)".r) should be (Success(6))
    countRegexMatches(dir, "and".r) should be (Success(26))
    countRegexMatches(dir, "(?i:tyger)".r) should be (Success(4))
  }

  test("returns 0 if no matches found") {
    val pattern = "this can't be there".r
    countRegexMatches(dir, pattern) should be (Success(0))
  }
}
