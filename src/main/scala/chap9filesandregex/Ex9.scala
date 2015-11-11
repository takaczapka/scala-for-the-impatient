package chap9filesandregex

import java.io.File

/**
 * 9. Write a Scala program that counts how many files with .class extension are in a given directory and
 * its subdirectories.
 */
object Ex9 {

  def howManyClassFiles(dir: File): Int = {

    val c = dir.listFiles().count { f => f.isFile && f.getName.endsWith(".class") }

    dir.listFiles().filter(_.isDirectory).foldLeft(c)((c, dir) => c + howManyClassFiles(dir))
  }
}
