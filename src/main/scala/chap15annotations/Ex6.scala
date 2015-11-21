package chap15annotations

/**
  * 6. Write a Scala object with a volatile Boolean field. Have one thread sleep for some time, then set the field
  * to true, print a message, and exit. Another thread will keep checking whether the field is true. If so, it prints
  * a message and exits. If not, it sleeps for a short time and tries again. What happens if the variable is not volatile?
  */
object Ex6 extends App {

  // @volatile
  var flag: Boolean = false

  val t2 = new Thread(new Runnable {
    override def run(): Unit = {
      while (!flag) {
        println("t2 checking")
        Thread.sleep(10)
      }
      println("t2 finished")
    }
  }).start()

  val t1 = new Thread(new Runnable {
    override def run(): Unit = {
      Thread.sleep(200)
      flag = true
      println("t1 finished")
    }
  }).start()


  // COMMENT
  // I understand that when the thread t2 is running while loop and thread t1 is setting flat to true,
  // the execution might run into an infinite loop if "volatile" is omitted, since the thread t2 might cache the value of stop.
  // But... I can't reproduce the infinite loop
}
