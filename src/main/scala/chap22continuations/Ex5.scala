package chap22continuations

import scala.util.continuations._

/**
  * 5. Consider this sample program that uses a continuation to turn an iteration into an iterator:
  *
  * [code below]
  *
  *
  * Compile with the -Xprint:selectivecps flag and look at the generated code. How is the while statement treated
  * when transformed to CPS?
  */
// selectivecps phase is not present in scala 2.11.7 compiler.
object Ex5 {

  object Main extends App {
    var cont: Unit => String = null
    val a = "Mary was a little lamb".split(" ")
    reset {
      var i = 0
      while (i < a.length) {
        shift { k: (Unit => String) => {
          cont = k
          a(i)
        }
        }
        i += 1

      }
      ""
    }
    println(cont())
    println(cont())
  }

}
