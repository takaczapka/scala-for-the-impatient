package chap2controlstructsandfuncs

/**
 * 10. Write a function that computes xn, where n is an integer.
 * Use the following recursive definition:
 * • x^n = y^2 if n is even and positive, where y = x^(n/2).
 * • x^n = x*x^(n – 1) if n is odd and positive.
 * • x0 = 1. • xn = 1 / x– n if n is negative.
 * Don’t use a return statement.
 */
object Ex10 {

  def pow(x: Double, n: Int): Double = {
    if (n == 0) 1.0
    else if (n > 0) {
      if (n % 2 == 0) {
        val y = pow(x, n / 2)
        y * y
      } else {
        x * pow(x, n - 1)
      }
    } else {
      1.0 / pow(x, -n)
    }
  }
}
