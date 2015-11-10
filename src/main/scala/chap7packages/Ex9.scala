package chap7packages

/**
 * 9. Write a program that imports the java.lang.System class, reads the user name from the user.name system property,
 * reads a password from the Console object, and prints a message to the standard error stream if the password
 * is not "secret". Otherwise, print a greeting to the standard output stream.
 * Do not use any other imports, and do not use any qualified names (with dots).
 */
object Ex9 extends App {

  override def main(args: Array[String]) {
    import java.lang.System._

    val user = getProperty("user.name")

    print("Enter password: ")
    val password = readLine()

    if (password == "secret") {
      println(s"Hello $user!")
    } else {
      err.println("Error while logging.")
    }
  }
}
