package chap17typeparams

/**
  * 8. In Section 17.10, “Co- and Contravariant Positions,” on page 238, the replaceFirst method has a type bound.
  * Why can’t you define an an equivalent method on a mutable Pair[T]?
  *
  * def replaceFirst[R >: T](newFirst: R) { first = newFirst } // Error
  */
object Ex8 {

  // R is a superclass of T, so such operation would change initial type of an existing Pair instance. Pair is
  // defined as invariant. It would be ok when the method spawns a new instance.
}
