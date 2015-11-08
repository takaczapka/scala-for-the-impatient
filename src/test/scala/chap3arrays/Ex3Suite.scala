package chap3arrays

import org.scalatest.FunSuite

class Ex3Suite extends FunSuite with SwapAdjacentElementsBehavior {

  override def swapAdjacentElements[T : Manifest](a: Array[T]): Array[T] = Ex3.swapAdjacentElements(a)
}
