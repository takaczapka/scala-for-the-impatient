package chap2controlstructsandfuncs

/**
 * 6. Write a for loop for computing the product of the Unicode codes
 * of all letters in a string. For example, the product of the characters
 * in "Hello" is 9415087488L.
 */
object Ex6 {

  def product(s: String): Long = {
    if (s == null || s == "") 0
    else (for (c <- s) yield c.toLong).product
  }
}
