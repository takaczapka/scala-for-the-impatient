package chap3arrays

import org.scalatest.FunSuite

class Ex2Suite extends FunSuite with SwapAdjacentElementsBehavior {

  override def swapAdjacentElements[T : Manifest](a: Array[T]): Array[T] = Ex2.swapAdjacentElements(a)
}
