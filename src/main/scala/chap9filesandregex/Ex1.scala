package chap9filesandregex

import java.io.File

import scala.io.Source

/**
 * 1. Write a Scala code snippet that reverses the lines in a file (making the last line the first one, and so on).
 */
object Ex1 {

  def reverseFileLines(file: File): Unit = {

    val lines = Source.fromFile(file).getLines().toSeq.reverse
    val pw = new java.io.PrintWriter(file)
    for (line <- lines) pw.println(line)
    pw.close()
  }
}
