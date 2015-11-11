package chap10traits

import java.io.{BufferedInputStream, InputStream}

import chap10traits.Ex4.Logger

/**
 * 9. Using the logger traits from this chapter, add logging to the solution of the preceding problem
 * that demonstrates buffering.
 */
object Ex9 {

  trait Buffering extends Logger {

    this: InputStream =>

    val bis = new BufferedInputStream(this)

    override def read(): Int = {
      val r = bis.read()
      log("Read bytes: " + r)
      r
    }

    override def read(a: Array[Byte]): Int = {
      val r = bis.read(a)
      log("Read bytes: " + r)
      r
    }
  }

}
