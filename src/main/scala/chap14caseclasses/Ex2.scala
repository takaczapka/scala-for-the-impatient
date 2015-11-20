package chap14caseclasses

/**
  * 2. Using pattern matching, write a function swap that receives a pair of integers and returns the pair with
  * the components swapped.
  */
object Ex2 {

  def swap(pair: (Int, Int)) = pair match {
    case (a, b) => (b, a)
  }
}
