package chap5classes

import org.scalatest.{FunSuite, Matchers}

class Ex7Suite extends FunSuite with Matchers {

  import Ex7.Person

  test("Person accepts space delimited name") {

    val p = new Person("Maciej Falski")

    p.firstName should be("Maciej")
    p.lastName should be("Falski")
  }

  test("Person constructor doesn't accepts space delimited name") {

    an[Exception] should be thrownBy {
      new Person("Maciej Falski Junior")
    }

    an[Exception] should be thrownBy {
      new Person("MaciejFalski")
    }
  }

}
