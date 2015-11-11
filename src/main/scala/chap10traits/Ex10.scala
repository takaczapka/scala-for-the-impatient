package chap10traits

import java.io.InputStream

/**
 * 10. Implement a class IterableInputStream that extends java.io.InputStream with the trait Iterable[Byte].
 */
object Ex10 {

  class IterableInputStream(inputStream: InputStream) extends InputStream with Iterable[Byte] {

    override def read(): Int = inputStream.read()

    override def iterator: Iterator[Byte] = Iterator.continually(read()).map(_.toByte)
  }

}
