package chap4maps

/**
 * 3. Repeat the preceding exercise with an immutable map.
 */
object Ex3 {

  def frequency(words: Seq[String]): Map[String, Int] = {
    words.foldLeft(Map[String, Int]()) {
      case (map, word) => map + (word -> (map.getOrElse(word, 0) + 1))
    }
  }
}
