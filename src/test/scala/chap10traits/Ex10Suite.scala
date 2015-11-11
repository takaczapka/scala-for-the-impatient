package chap10traits

import java.io.FileInputStream

import helpers.FileHelpers
import org.scalatest.{FunSuite, Matchers, OneInstancePerTest}

class Ex10Suite extends FunSuite with Matchers with OneInstancePerTest {

  import Ex10._
  
  test("iterate through the content") {
    val content = "find what you love and let it kill you"

    val file = FileHelpers.createTempFile(content)
    val iis = new IterableInputStream(new FileInputStream(file))

    new String(iis.iterator.takeWhile(_ != -1).toArray) should be(content)
  }
}