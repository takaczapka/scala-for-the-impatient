package helpers

object Helpers {
  val runtime = Runtime.getRuntime

  def cleanup(): Unit = {
    System.gc()
    Thread.sleep(1000)
  }

  def measureIt(block: => Unit): Unit = {
    cleanup()

    val startFreeMemory = runtime.freeMemory()
    val start = System.currentTimeMillis()
    block
    println("Time to complete: " + (System.currentTimeMillis() - start))
    println("Memory before: " + startFreeMemory)
    println("Memory after: " + runtime.freeMemory())

    cleanup()
  }

}
