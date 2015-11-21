package chap17typeparams

import chap17typeparams.Ex1.ImmutablePair

/**
  * 3. Given a class Pair[T, S], write a generic method swap that takes a pair as its argument and returns a new pair
  * with the components swapped.
  */
object Ex3 {

  object ImmutablePair {
    def swap[T, S](p: ImmutablePair[T, S]) = new ImmutablePair[S, T](p.b, p.a)
  }
}
