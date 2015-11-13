package chap12higherorderfunc

/**
 * 6. Modify the previous function to return the input at which the output is largest.
 * For example, largestAt( fun: (Int) = > Int, inputs: Seq[ Int]) should return 5. Don’t use a loop or recursion.
 */
object Ex6 {

  def largestInput(fun: Int => Int, inputs: Seq[Int]) = {
    inputs.map(i => i -> fun(i)).maxBy { case (x, y) => y }._1
  }
}
