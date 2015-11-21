package chap18advancedtypes

/**
  * 6. The Either type in the Scala library can be used for algorithms that return either a result or some
  * failure information. Write a function that takes two parameters: a sorted array of integers and an integer value.
  * Return either the index of the value in the array or the index of the element that is closest to the value.
  * Use an infix type as the return type.
  */
object Ex6 {

  def foo(sArray: Array[Int], i: Int): Either[Int, Int] = {
    val index: Int = sArray.indexWhere(_ > i)
    val found =
      if (index == -1 || index == sArray.length - 1) sArray.length
      else if (index == 0) 0
      else {
        if (math.abs(sArray(index - 1) - i) <= math.abs(sArray(index) - i)) index - 1
        else index
      }

    if (sArray(found) == i) Right(found) else Left(found)
  }
}
