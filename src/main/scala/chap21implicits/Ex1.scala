package chap21implicits

/**
  * 1. How does -> work? That is, how can "Hello" -> 42 and 42 -> "Hello" be pairs ("Hello", 42) and (42, "Hello")?
  */
object Ex1 extends App {

  // ANSWER
  // an implicit enrichment is defined to apply to any generic type A which introduces a new operator -> which takes
  // an argument of any type B, and as a result Tuple2 instance is created. Simplified version here:
  implicit final class Boom[A](private val p1: A) {
    def -->[B](p2: B): Tuple2[A, B] = Tuple2(p1, p2)
  }

  val pair: (String, Int) = "23232" --> 232
}
