package chap3arrays

/**
 * 2. Write a loop that swaps adjacent elements of an array of integers. For example,
 * Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
 */
object Ex2 {

  // function but does it in the same array
  def swapAdjacentElements[T: Manifest](a: Array[T]): Array[T] = {
    if (a == null || a.length <= 1) a
    else {
      for (i <- 1 until a.length by 2) {
        val acc = a(i - 1)
        a(i - 1) = a(i)
        a(i) = acc
      }
      a
    }
  }
}
