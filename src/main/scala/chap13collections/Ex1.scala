package chap13collections

import scala.collection.mutable

/**
 * 1. Write a function that, given a string, produces a map of the indexes of all characters. For example,
 * indexes("Mississippi") should return a map associating 'M' with the set {0}, 'i' with the set {1, 4, 7, 10},
 * and so on. Use a mutable map of characters to mutable sets. How can you ensure that the set is sorted?
 */
object Ex1 {

  def indexes(s: String) = {
    val m: mutable.Map[Char, mutable.TreeSet[Int]] = mutable.Map[Char, mutable.TreeSet[Int]]()
    s.zipWithIndex.foreach {
      case (c, i) => m.update(c, m.getOrElse(c, mutable.TreeSet.empty[Int]) + i)
    }

    m.toMap
  }

  // We can ensure that the set is sorted by using a TreeSet structure which guarantees sorting of its elements.
}
