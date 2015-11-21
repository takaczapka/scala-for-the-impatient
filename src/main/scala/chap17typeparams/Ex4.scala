package chap17typeparams

/**
  * 4. Why don’t we need a lower bound for the replaceFirst method in Section 17.3, “Bounds for Type Variables,”
  * on page 232 if we want to replace the first component of a Pair[Person] with a Student?
  */
object Ex4 {

  // ANSWER
  //
  //    def replaceFirst[R >: T](n: R) = new Pair(n, b)
  //
  // because subclass can be presented as T, or R. Well if S <: T then S <: R, so it's totally legal to call it
  // with subclass of T. In other words, Student is already a Person.
}
