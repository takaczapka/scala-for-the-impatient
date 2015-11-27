package chap22continuations

import org.scalatest.{Matchers, FunSuite}

import scala.collection.mutable.ArrayBuffer
import scala.util.continuations._

// really good blog post: http://jim-mcbeath.blogspot.com.es/2010/08/delimited-continuations.html
class MoreContinuationsSuite extends FunSuite with Matchers {

  test("multiple applications") {

    reset {
      shift { k: (Int => Int) =>
        k(1)
      } + 1
    } should be(2)

    reset {
      shift { k: (Int => Int) =>
        k(k(k(1)))
      } + 1
    } should be(4)

    // which translates to
    /*
     reset {
      def f(x: Int) = x + 1
      f(f(f(1)))
     }
     */
  }

  test("more than one shift") {
    val buf = new ArrayBuffer[Char]()

    reset[Unit, Unit] {
      buf += 'A'
      shift[Unit, Unit, Unit] { k1: (Unit => Unit) =>
        buf += 'B'
        k1()
        buf += 'C'
      }
      buf += 'D'
      shift[Unit, Unit, Unit] { k2: (Unit => Unit) =>
        buf += 'E'
        k2()
        buf += 'F'
      }
      buf += 'G'
      println("done")
    }

    buf.mkString should be("ABDEGFC")
  }
}
