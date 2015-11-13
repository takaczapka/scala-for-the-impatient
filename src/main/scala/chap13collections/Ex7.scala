package chap13collections

/**
 * 7. In Section 13.11, “Zipping,” on page 171, the expression (prices zip quantities) map { p = > p._1 * p._2 }
 * is a bit inelegant. We can’t do (prices zip quantities) map { _ * _ } because _ * _ is a function with two arguments,
 * and we need a function with one argument that is a tuple. The tupled method of the Function2 class changes a function
 * with two arguments to one that takes a tuple. Apply tupled to the multiplication function so you can map it over the
 * list of pairs.
 */
object Ex7 {
  // see Ex7Suite
}
