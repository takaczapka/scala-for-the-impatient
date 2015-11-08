package chap4maps

import scala.collection.immutable.TreeMap

/**
 * 4. Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.
 */
object Ex4 {

  def frequency(words: Seq[String]): TreeMap[String, Int] = {
    words.foldLeft(TreeMap[String, Int]()) {
      case (map, word) => map + (word -> (map.getOrElse(word, 0) + 1))
    }
  }
}
