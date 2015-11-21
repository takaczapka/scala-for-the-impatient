package chap17typeparams

/**
  * 1. Define an immutable class Pair[T, S] with a method swap that returns a new pair with the components swapped.
  */
object Ex1 {

  class ImmutablePair[T, S](val a: T, val b: S) {
    def swap = new ImmutablePair(b, a)
  }
}
