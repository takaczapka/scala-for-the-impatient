package chap13collections

/**
 * 2. Repeat the preceding exercise, using an immutable map of characters to lists.
 */
object Ex2 {

  def indexes(s: String): Map[Char, Set[Int]] = {
    s.zipWithIndex.foldLeft(Map.empty[Char, Set[Int]]) {
      case (m, (c, i)) => m + (c -> (m.getOrElse(c, Set.empty[Int]) + i))
    }
  }

}
