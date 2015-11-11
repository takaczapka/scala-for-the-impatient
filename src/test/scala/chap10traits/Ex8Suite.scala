package chap10traits

import java.awt.Point
import java.beans.{PropertyChangeEvent, PropertyChangeListener}
import java.io.FileInputStream

import chap10traits.Ex4.PrintLogger
import helpers.FileHelpers
import org.scalatest.{OneInstancePerTest, FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers with OneInstancePerTest {

  import Ex8._

  val content = "find what you love and let it kill you"

  val f = FileHelpers.createTempFile(content)
  val is = new FileInputStream(f) with Buffering

  test("reading buffered arrays") {

    val sb = new StringBuffer
    val array = new Array[Byte](10)
    var offset = -1

    while ({offset = is.read(array); offset != -1} ) { sb.append(new String(array.take(offset))) }

    sb.toString should be (content)
  }

  test("reading buffered bytes") {

    val sb = Stream.continually(is.read()).takeWhile(_ != -1).foldLeft(new StringBuffer())((sb, v) => sb.append(v.toChar))

    sb.toString should be (content)
  }
}
