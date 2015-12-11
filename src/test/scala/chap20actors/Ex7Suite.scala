package chap20actors

import org.scalatest.{FunSuite, Matchers}

import scala.util.Failure

class Ex7Suite extends FunSuite with Matchers {

  import Ex7.findAllMatchesWithFilesWithErrors

  val dir = getClass.getResource("/chap20actors/poems").getFile

  test("Due to errors work is not finished") {
    val Failure(exception) = findAllMatchesWithFilesWithErrors(dir, "(?i:he.*ven)".r)

    exception.getMessage should be ("file-not-exist-1 (No such file or directory)")
  }
}
