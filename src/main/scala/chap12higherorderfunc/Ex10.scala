package chap12higherorderfunc

/**
 * 10. Implement an unless control abstraction that works just like if, but with an inverted condition.
 * Does the first parameter need to be a call-by-name parameter? Do you need currying?
 */
object Ex10 {

  def unless(condition : => Boolean)(block: => Unit): Unit = {
    if (!condition) {
      block
      unless(condition)(block)
    }
  }

  def unlessWithoutCurrying(condition : => Boolean, block: => Unit): Unit = {
    if (!condition) {
      block
      unlessWithoutCurrying(condition, block)
    }
  }


  // ANSWER
  // "condition" has to be a call-by-name parameter as its evaluation cannot be eager but lazy.
  // Currying in not strictly required, however it makes a use of "unless" structure more readable or
  // at least looks more like a real statement.
}
