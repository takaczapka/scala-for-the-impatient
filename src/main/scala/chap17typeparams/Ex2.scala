package chap17typeparams

/**
  * 2. Define a mutable class Pair[T] with a method swap that swaps the components of the pair.
  */
object Ex2 {

  class MutablePair[T](private var a: T, private var b: T) {
    def swap(): Unit = {
      val acc = b
      b = a
      a = acc
    }
  }

}
