package chap12higherorderfunc

/**
 * 3. Implement the factorial function using to and reduceLeft, without a loop or recursion.
 */
object Ex3 {

  def factorial(i: Int) = {
    if (i <= 0) 1
    else (1 to i).reduceLeft((c, e) => c * e)
  }
}
