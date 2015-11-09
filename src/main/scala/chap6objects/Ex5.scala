package chap6objects

/**
 * 5. Write a Scala application, using the App trait, that prints the command-line arguments
 * in reverse order, separated by spaces. For example, scala Reverse Hello World should print World Hello.
 */
object Ex5 {
}

object Reverse extends App {

  override def main(args: Array[String]) {
    if (args != null) println(args.reverse.mkString(" "))
  }
}
