package chap18advancedtypes

import org.scalatest.{FunSuite, Matchers}

class Ex3Suite extends FunSuite with Matchers {

  import Ex3._

  test("a fluent document lang") {

    val book = new Document
    book.title should be (null)
    book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
    book.title should be ("Scala for the Impatient")
    book.author should be ("Cay Horstmann")
  }
}
