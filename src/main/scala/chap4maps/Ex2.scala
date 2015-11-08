package chap4maps

import scala.io.Source

/**
 * 2. Write a program that reads words from a file. Use a mutable map to count how often each word appears.
 * To read the words, simply use a
 *
 * java.util.Scanner:
 * val in = new java.util.Scanner(new java.io.File("myfile.txt"))
 * while (in.hasNext()) process in.next()
 *
 * (or look for a Scalaesque way)
 *
 * At the end, print out all words and their counts.
 */
object Ex2 extends App {

  def frequency(words: Seq[String]): Map[String, Int] = {
    words.foldLeft(collection.mutable.Map[String, Int]()) {
      case (map, word) => map.update(word, map.getOrElse(word, 0) + 1); map
    }.toMap
  }

  val words = Source.fromInputStream(getClass.getResourceAsStream("/chap4maps/ex2.txt")).mkString.split("\\s")
  frequency(words).foreach(println)
}
