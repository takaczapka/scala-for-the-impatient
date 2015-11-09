package chap5classes

/**
 * 6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods Why No Multiple Inheritance?,”
 * on page 49, provide a primary constructor that turns negative ages to 0.
 */
object Ex6 {

  class Person(initialAge: Int) {
    var age = if (initialAge < 0) 0 else initialAge
  }
}
