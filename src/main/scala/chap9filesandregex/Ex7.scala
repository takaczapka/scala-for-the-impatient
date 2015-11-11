package chap9filesandregex

import java.io.File

import scala.io.Source

/**
 * 7. Write a Scala program that reads a text file and prints all tokens in the file that are
 * not floating-point numbers. Use a regular expression.
 */
object Ex7 {
  def findAllNoFloatingPointItems(file: File): Iterator[String] = {
    val noFloatPattern = """[0-9]+(\.[0-9]+)?""".r

    Source.fromFile(file).getLines().flatMap(noFloatPattern.split)
  }
}
