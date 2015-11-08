package chap2controlstructsandfuncs

/**
 * 7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
 */
object Ex7 {

  def product(s: String): Long = {
    if (s == null || s == "") 0
    else s.map(_.toLong).product
  }
}
