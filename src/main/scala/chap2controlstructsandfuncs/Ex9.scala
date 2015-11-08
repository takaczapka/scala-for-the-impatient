package chap2controlstructsandfuncs

import scala.annotation.tailrec

/**
 * 9. Make the function of the preceding exercise a recursive function.
 */
object Ex9 {

  @tailrec
  final def product(s: String, res: Long = 0): Long = {
    if (s == null || s == "") res
    else product(s.tail, (if (res == 0) 1 else res) * s(0).toLong)
  }
}
