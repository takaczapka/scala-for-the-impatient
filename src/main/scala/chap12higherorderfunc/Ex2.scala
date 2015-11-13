package chap12higherorderfunc

/**
 * 2. How do you get the largest element of an array with reduceLeft?
 */
object Ex2 {
  def max(a: Array[Int]) = {
    a.reduceLeft((m, e) => if (m < e) e else m)
  }
}
