package chap22continuations

import scala.util.continuations._

/**
  * 2. Improve the example of Section 22.1, “Capturing and Invoking a Continuation,” on page 320 so that the
  * continuation function passes the name of the next file to try as a parameter.
  */
object Ex2 extends App {

  var cont: (String) => Unit = null

  var contents = ""


  def readContents(filename: String) = {
    try {
      contents = scala.io.Source.fromFile(filename, "UTF-8").mkString
    }
    catch {
      case _: Throwable => println("brrrroke! file not found.")
    }
  }

  var filename: String = "myfile.txt"
  reset {
    while (contents == "") {
      readContents(
        shift { k: (String => Unit) =>
          cont = k
        }
      )
    }
  }

  cont("myfile.txt")
  cont("src/main/resources/chap4maps/ex2.txt")
  println("Contents: " + contents)
}
