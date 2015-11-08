package chap2controlstructsandfuncs

/**
 * 1. The signum of a number is 1 if the number is positive, –1 if it is negative,
 *    and 0 if it is zero. Write a function that computes this value.
 */
object Ex1 {
  def signum(i: Int): Int = if (i < 0) -1 else if (i == 0) 0 else 1
}
