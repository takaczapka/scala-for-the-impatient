package chap5classes

/**
 * 1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless MethodsWhy No Multiple Inheritance?,”
 * on page 49 so that it doesn’t turn negative at Int.MaxValue.
 */
object Ex1 {

  class Counter {

    private var value = 0

    def increment() { value = (value + 1) % Int.MaxValue }

    def current() = value
  }
}
