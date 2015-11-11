package chap9filesandregex

import java.io.File

import scala.io.Source

/**
 * 4. Write a Scala program that reads a text file containing only floating-point numbers. Print the sum, average,
 * maximum, and minimum of the numbers in the file.
 */
object Ex4 {

  def floatingResults(file: File): (Float, Float, Float, Float) = {
    val floatPattern = """\d+(\.\d+)?""".r

    val nums = Source.fromFile(file).getLines().flatMap(floatPattern.findAllIn).map(_.toFloat).toArray

    (nums.sum,
      nums.sum / nums.length,
      nums.max,
      nums.min)
  }
}
