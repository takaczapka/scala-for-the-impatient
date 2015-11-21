package chap18advancedtypes

/**
  * 8. Write a function printValues with three parameters f, from, to that prints all values of f with inputs
  * from the given range. Here, f should be any object with an apply method that consumes and yields an Int.
  * For example,
  *
  * printValues(( x: Int) = > x * x, 3, 6) // Prints 9 16 25 36
  * printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6) // Prints 3 5 8 13
  */
object Ex8 {

  def printValues(c: {def apply(i: Int): Int}, from: Int, to: Int): String = {
    (for (i <- from to to) yield c(i)).mkString(" ")
  }
}
