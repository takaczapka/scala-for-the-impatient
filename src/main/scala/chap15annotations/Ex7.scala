package chap15annotations

import scala.annotation.tailrec

/**
  * 7. Give an example to show that the tail recursion optimization is not valid when a method can be overridden.
  */
object Ex7 {

  // it has to be final, otherwise it will not compile
  @tailrec
  final def rec(i: Int, res: Int = 0): Int = {
    if (i <= 0) res else rec(i - 1, res + i)
  }
}
