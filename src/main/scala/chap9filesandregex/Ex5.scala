package chap9filesandregex

import java.io.{PrintWriter, File}

/**
 * 5. Write a Scala program that writes the powers of 2 and their reciprocals to a file, with the exponent
 * ranging from 0 to 20. Line up the columns:
 * 1       1
 * 2       0.5
 * 4       0.25
 * ...     ...
 */
object Ex5 {

  def streamOf2 = Stream.iterate((1, 1.0)){ case (i, j) => i * 2 -> j / 2.0 }

  def powOf2(file: File): Unit = {

    val a = streamOf2.take(21).map { case (a, b) => (a.toString, b.toString) }

    val ml = a.map(_._1.length).last

    val pw = new PrintWriter(file)
    a.foreach { case (a, b) =>
      pw.println((" " * (ml - a.length)) + a + "     " + b)
    }
    pw.close()
  }
}
