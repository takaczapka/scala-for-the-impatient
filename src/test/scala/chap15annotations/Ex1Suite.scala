package chap15annotations

import org.junit.Assert._
import org.junit.Test

class Ex1Suite {

  @Test
  def testMeWithJunit(): Unit = {
    assertEquals(4, 2 + 2)
  }
}
