package chap22continuations

import scala.util.continuations._

/**
  * 1. In the example of Section 22.1, “Capturing and Invoking a Continuation,” on page 320, suppose there is no file
  * myfile.txt. Now set filename to another nonexistent file and call cont. What happens? Set filename to a file that
  * exists and call cont again. What happens? Call cont one more time. What happens? First, think through
  * the control flow, then run a program to verify.
  */

// ANSWER

// Every time the file is not found, the continuation block runs and the execution is suspended.
// When a new file is set and cont() runs, the block after continuation is executed, in this case rest of while look block.
// And execution comes back to the top of the while as long as the file is not found and its contents are not empty.
object Ex1 extends App {

  var cont: (Unit => Unit) = null
  var filename = "myfile.txt"
  var contents = ""

  reset {
    while (contents == "") {
      println("let's dance!")
      try {
        contents = scala.io.Source.fromFile(filename, "UTF-8").mkString
      }
      catch {
        case _: Throwable => println("brrrroke! file not found.")
      }
      shift { k: (Unit => Unit) =>
        println("ok, I'm in shift. filename = " + filename)
        cont = k
        println("leaving the shift")
      }
      println("end of while")
    }
  }

  if (contents == "") {
    println("try another file")
    filename = "src/main/resources/chap4maps/ex2.txt"
    cont()
  }
  println("Contents: " + contents)
}
