package chap20actors

import org.scalatest.{FunSuite, Matchers}

import scala.util.Success

class Ex4Suite extends FunSuite with Matchers {

  import Ex4.findAllMatches
  val dir = getClass.getResource("/chap20actors/poems").getFile

  test("Finds all matches") {
    findAllMatches(dir, "(?i:he.*ven)".r).map(_.toSet) should be (Success(Set("Heaven", "he Lies you can inven", "he Heaven", "heaven")))
  }
}

class TryMonad