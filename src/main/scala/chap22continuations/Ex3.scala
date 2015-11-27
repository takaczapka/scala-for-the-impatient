package chap22continuations

import scala.util.continuations._
import java.io._

/**
  * 3. Make the example in Section 22.7, “Turning a Recursive Visit into an Iteration,” on page 326 into an iterator.
  * The constructor of the iterator should contain the reset, and the next method should invoke the continuation.
  */
object Ex3 extends App {

  class FileIterator(root: File) extends Iterator[File] {

    var cont: (Unit => Unit) = null

    var cur: File = null

    def processDirectory(dir: File): Unit@cps[Unit] = {
      val files = dir.listFiles
      var i = 0
      while (i < files.length) {
        val f = files(i)
        i += 1
        if (f.isDirectory)
          processDirectory(f)
        else {
          shift {
            k: (Unit => Unit) => {
              cont = k
            }
          }
          cur = f
        }
      }
      cur = null
    }

    reset {
      processDirectory(root)
    }

    cont()

    // to kick it off

    override def hasNext: Boolean = cur != null

    override def next(): File = {
      val c = cur
      cont()
      c
    }
  }

}

