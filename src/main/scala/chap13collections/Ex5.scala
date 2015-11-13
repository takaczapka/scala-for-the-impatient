package chap13collections

/**
 * 5. Implement a function that works just like mkString, using reduceLeft.
 */
object Ex5 {

  def mkString(s: Iterable[Any], separator: String = ""): String = {
    if (s.isEmpty) ""
    else s map (_.toString) reduceLeft (_ + separator + _)
  }
}
