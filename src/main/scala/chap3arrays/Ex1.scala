package chap3arrays

/**
 * 1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
 */
object Ex1 {

  val MAX_LENGTH = 100

  import util.Random.nextInt

  def randomArray(n: Int): Array[Int] = {
    (for (e <- 0 to nextInt(MAX_LENGTH)) yield nextInt(n)).toArray
  }
}
