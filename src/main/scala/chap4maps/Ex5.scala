package chap4maps

/**
  * 5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
  */
object Ex5 {

  import collection.JavaConversions.mapAsScalaMap

  def frequency(words: Seq[String]): Map[String, Int] = {
    words.foldLeft(new java.util.TreeMap[String, Int]()) {
      case (map, word) =>
        val newMap = new java.util.TreeMap[String, Int](map)
        newMap.put(word, map.getOrElse(word, 0) + 1)
        newMap
    }
  }.toMap
}
