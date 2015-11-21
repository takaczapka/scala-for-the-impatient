package chap15annotations

import java.io.{File, IOException}

import scala.io.Source

/**
  * 5. Write a Scala method that returns a string containing all lines of a file. Call it from Java.
  */
object Ex5 extends App {

  @throws(classOf[IOException])
  def lines(file: File): String = {
    Source.fromFile(file).mkString
  }
}