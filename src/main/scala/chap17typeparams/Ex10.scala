package chap17typeparams

/**
  * 10. Given a mutable Pair[S, T] class, use a type constraint to define a swap method that can be called if
  * the type parameters are the same.
  */
object Ex10 extends App {

  class MutablePair10[S, T](var a: S, var b: T) {
    def swap(implicit ev1: S =:= T, ev2: T =:= S) = {
      val acc: T = b
      b = a
      a = acc
    }
  }

  new MutablePair10(1, 2).swap

  // will not compile
  // new MutablePair10(1, "hello").swap
}
