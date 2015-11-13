package chap13collections

/**
 * 4. Write a function that receives a collection of strings and a map from strings to integers.
 * Return a collection of integers that are values of the map corresponding to one of the strings in the collection.
 * For example, given Array(" Tom", "Fred", "Harry") and Map(" Tom" -> 3, "Dick" -> 4, "Harry" -> 5),
 * return Array( 3, 5). Hint: Use flatMap to combine the Option values returned by get.
 */
object Ex4 {
  
  def doTheMagic(s: Seq[String], m: Map[String, Int]): Seq[Int] = {
    s flatMap m.get
  }

}
