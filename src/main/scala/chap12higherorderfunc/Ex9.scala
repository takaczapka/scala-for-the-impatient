package chap12higherorderfunc

import scala.collection.GenSeq

/**
 * 9. Implement corresponds without currying. Then try the call from the preceding exercise. What problem do you
 * encounter?
 */
object Ex9 extends App {

  implicit class MyArray[A](val a: Array[A]) {

    def corresponds2[B](that: GenSeq[B], p: (A, B) => Boolean): Boolean = {
      val i = a.iterator
      val j = that.iterator
      while (i.hasNext && j.hasNext)
        if (!p(i.next(), j.next()))
          return false

      !i.hasNext && !j.hasNext
    }
  }

  val a = Array("I", "am", "here")
  val b = Array(1, 2, 4)

  println(a.corresponds2[Int](b, (a, b) => a.length == b))


  // ANSWER
  // I can't call it corresponds2 in the same as original Array's corresponds function as it takes two params
  // now and returns a result straight away.
}
