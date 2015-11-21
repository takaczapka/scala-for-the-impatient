package chap17typeparams

/**
  * 9. It may seem strange to restrict method parameters in an immutable class Pair[+T]. However, suppose you
  * could define
  *
  * def replaceFirst(n: T)
  *
  * in a Pair[T]. The problem is that this method can be overridden in an unsound way. Construct an example of
  * the problem. Define a subclass NastyDoublePair of Pair[Double] that overrides replaceFirst so that it makes
  * a pair with the square root of newFirst. Then construct the the call replaceFirst("Hello") on a Pair[Any] that
  * is actually a NastyDoublePair.
  */
object Ex9 {

//  class Pair[+T](val a: T, val b: T) {
//    def replaceFirst(n: T) = new Pair(n, b)
//  }
//
//  class NastyDoublePair(a: Double, b: Double) extends Pair[Double](a, b) {
//    override def replaceFirst(n: Double) = new Pair(math.sqrt(n), b)
//  }
//
//  object Ex9 extends App {
//    val a: Pair[Any] = new NastyDoublePair(2, 3)
//    a.replaceFirst("Booom!")
//  }
}
