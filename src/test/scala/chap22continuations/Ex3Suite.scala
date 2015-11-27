package chap22continuations

import java.io.File

import org.scalatest.{Matchers, FunSuite}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3._

  test("file iterator") {

    val dir = new File("src/main/scala/chap22continuations/")
    val res = new FileIterator(dir).take(4).map(_.getName).toSeq

    res should be (Seq("Ex1.scala", "Ex2.scala", "Ex3.scala", "Ex4.scala"))
  }
}
