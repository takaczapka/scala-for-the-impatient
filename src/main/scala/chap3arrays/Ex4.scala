package chap3arrays

/**
 * 4. Given an array of integers, produce a new array that contains all
 * positive values of the original array, in their original order, followed
 * by all values that are zero or negative, in their original order.
 */
object Ex4 {

  def orderIntArray(a: Array[Int]): Array[Int] = {
    if (a == null) null
    else {
      val first = for (e <- a if e > 0) yield e
      val second = for (e <- a if e <= 0) yield e
      first ++ second
    }
  }
}
