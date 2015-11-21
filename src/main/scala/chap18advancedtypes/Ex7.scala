package chap18advancedtypes

/**
  * 7. Implement a method that receives an object of any class that has a method def close(): Unit together
  * with a function that processes that object. Call the function and invoke the close method upon completion,
  * or when any exception occurs.
  */
object Ex7 {

  type Closeable = {
    def close(): Unit
  }

  def boom(c: Closeable, f: Closeable => Unit): Unit = {
    try {
      f(c)
    } finally {
      c.close()
    }
  }
}
