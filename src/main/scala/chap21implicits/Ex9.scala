package chap21implicits

/**
  * 9. Look up the =:= object in Predef.scala. Explain how it works.
  */
object Ex9 {
  def fun[A, B](a: A, b: B)(implicit ev: A =:= B): Unit = {
    // ...
  }

  // =:= is a class in the Scala Predef object, and by supplying it as a evidence in a function definition
  // it makes a compiler to look in the companion object for implicit conversions from A to B.\\
  // =:= is expressed as a invariant Function(A, B), hence there has to be a direct conversion from A to B.
  // Without =:= we would need to specify directly and conversions here, but using evidence feature
  // we can keep it more generic.
}
