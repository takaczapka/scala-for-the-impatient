package chap10traits

import java.io.{BufferedInputStream, InputStream}

/**
 * 8. In the java.io library, you add buffering to an input stream with a BufferedInputStream decorator.
 * Reimplement buffering as a trait. For simplicity, override the read method.
 */
object Ex8 {

  trait Buffering {

    this: InputStream =>

    val bis = new BufferedInputStream(this)

    override def read(): Int = {
      bis.read()
    }

    override def read(a: Array[Byte]): Int = {
      bis.read(a)
    }
  }

}
