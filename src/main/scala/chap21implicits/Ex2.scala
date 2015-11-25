package chap21implicits

/**
  * 2. Define an operator +% that adds a given percentage to a value. For example, 120 +% 10 should be 132.
  * Hint: Since operators are methods, not functions, you will also need to provide an implicit.
  */
object Ex2 extends App {

  implicit class PercInt(i: Int) {
    def +%(v: Int) = i + (i * v) / 100
  }
}
