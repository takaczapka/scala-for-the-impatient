package chap17typeparams

/**
  * 5. Why does RichInt implement Comparable[Int] and not Comparable[RichInt]?
  */
object Ex5 {

  // ANSWER
  //
  // RichInt provide extensions for Int type and Comparable type is not covariant.
  // Main purpose of RichInt is to provide an implicit conversion for Int along with missing Comparable[Int].
}
