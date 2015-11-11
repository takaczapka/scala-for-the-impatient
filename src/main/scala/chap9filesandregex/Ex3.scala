package chap9filesandregex

import java.io.File

import scala.io.Source

/**
 * 3. Write a Scala code snippet that reads a file and prints all words with more than 12 characters to the console.
 * Extra credit if you can do this in a single line.
 */
object Ex3 {

  def findOnlyLongerThan3CharWords(file: File): Iterator[String] = {
    Source.fromFile(file).getLines().flatMap(_.split( """\s""")).filter(_.length > 3)
  }
}
