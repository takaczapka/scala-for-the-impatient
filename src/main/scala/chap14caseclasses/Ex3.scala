package chap14caseclasses

/**
  * 3. Using pattern matching, write a function swap that swaps the first two elements of an array provided its length
  * is at least two.
  */
object Ex3 {

  def swapInArr(arrray: Array[Int]) = arrray match {
    case Array(a, b, rest@_*) => Array(b, a) ++ rest
    case _ => arrray
  }
}
