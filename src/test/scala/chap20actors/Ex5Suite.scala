package chap20actors

import org.scalatest.{FunSuite, Matchers}

import scala.util.Success

class Ex5Suite extends FunSuite with Matchers {

  import Ex5.findAllMatchesWithFiles

  val dir = getClass.getResource("/chap20actors/poems").getFile

  test("Finds all matches") {
    findAllMatchesWithFiles(dir, "(?i:he.*ven)".r) should be (Success(Map(
      "Heaven" -> Set("auguries-of-innocence.txt", "a-cradle-song.txt"),
      "heaven" -> Set("the-tyger.txt"),
      "he Lies you can inven" -> Set("auguries-of-innocence.txt"),
      "he Heaven" -> Set("auguries-of-innocence.txt"))))
  }
}
