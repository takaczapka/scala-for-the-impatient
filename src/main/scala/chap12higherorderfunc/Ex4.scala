package chap12higherorderfunc

/**
 * 4. The previous implementation needed a special case when n < 1. Show how you can avoid this with foldLeft.
 * (Look at the Scaladoc for foldLeft. It’s like reduceLeft, except that the first value in the chain of combined
 * values is supplied in the call.)
 */
object Ex4 {

  def factorial(i: Int) = {
    (1 to i).foldLeft(1)((c, e) => c * e)
  }
}
