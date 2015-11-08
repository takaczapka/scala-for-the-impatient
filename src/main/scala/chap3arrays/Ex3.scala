package chap3arrays

/**
 * 3. Repeat the preceding assignment, but produce a new array with the swapped values. Use for/ yield.
 */
object Ex3 {

  // function but does it in the same array
  def swapAdjacentElements[T: Manifest](a: Array[T]): Array[T] = {
    if (a == null || a.length <= 1) a
    else {
      val res = (for (i <- 1 until a.length by 2) yield Array(a(i), a(i-1))).flatten.toArray
      if (a.length % 2 == 1) res :+ a.last
      else res
    }
  }
}
