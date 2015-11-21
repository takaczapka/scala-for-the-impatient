package chap15annotations

import scala.annotation.varargs

/**
  * 4. Write a Scala method sum with variable integer arguments that returns the sum of its arguments. Call it from Java.
  */
object Ex4 {

  @varargs
  def sum(ints: Int*): Int = ints.sum
}
