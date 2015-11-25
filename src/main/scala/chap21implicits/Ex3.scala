package chap21implicits

import scala.annotation.tailrec
import scala.language.postfixOps

/**
  * ,3. It would be nice if we could define a factorial operator so that 5! is 120. Why can’t that work?
  * Make it work for ¡ instead.
  */
object Ex3 extends App {

  // In this version of Scala there is no problem with !

  implicit class FactorialInt(i: Int) {
    def ! : Int = fact(i)

    @tailrec
    final private def fact(i: Int, acc: Int = 1): Int = if (i > 0) fact(i - 1, acc * i) else acc
  }
}
