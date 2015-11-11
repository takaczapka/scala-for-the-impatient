package chap9filesandregex

import java.io.File

import scala.io.Source

/**
 * 2. Write a Scala program that reads a file with tabs, replaces each tab with spaces so that tab stops
 * are at n-column boundaries, and writes the result to the same file.
 */
object Ex2 {

  def replaceTabs(file: File, spaces: Int = 2): Unit = {
    val replacement = " " * spaces
    val text = Source.fromFile(file).mkString.replaceAll("\t", replacement)
    val pw = new java.io.PrintWriter(file)
    pw.print(text)
    pw.close()
  }
}
