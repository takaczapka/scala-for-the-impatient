package chap5classes

/**
 * 7. Write a class Person with a primary constructor that accepts a string containing a first name, a space,
 * and a last name, such as new Person("Fred Smith"). Supply read-only properties firstName and lastName.
 * Should the primary constructor parameter be a var, a val, or a plain parameter? Why?
 */
object Ex7 extends App {

  class Person(name: String) {

    val pattern = "(\\w+) (\\w+)".r

    val pattern(firstName, lastName) = name
  }

  // ANSWER
  // Primary constructor parameter should be a plain parameter, as there is no requirement to expose it or
  // keep it for any internal usage - it serves only construction requirements.
}
