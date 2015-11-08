package chap3arrays

import scala.collection.mutable.ArrayBuffer

/**
 * 8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on page 32. Collect
 * indexes of the negative elements, reverse the sequence, drop the last index, and call a.remove(i)
 * for each index. Compare the efficiency of this approach with the two approaches in Section 3.4.
 */
object Ex8 {

  def removeAllNegativesButFirst(a: ArrayBuffer[Int]): Unit = {
    val negativeIndices = for (i <- a.indices if a(i) < 0) yield i
    if (negativeIndices.nonEmpty) {
      val indicesToRemove = negativeIndices.tail.reverse
      for (i <- indicesToRemove.indices) a.remove(indicesToRemove(i))
    }
  }

  // ANSWER
  // It's still not as efficient as copying and trimming rest of the ArrayBuffer.
  // Remove regardless the position is in a linera time (to copy contents of an
  // underlying array.
}
