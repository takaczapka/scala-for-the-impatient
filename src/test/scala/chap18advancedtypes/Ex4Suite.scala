package chap18advancedtypes

import org.scalatest.{FunSuite, Matchers}

class Ex4Suite extends FunSuite with Matchers {

  import Ex4._

  test("members of two different networks can't be equal") {

    val chatter = new Network
    val myFace = new Network

    val fred: chatter.Member = chatter.join("Fred")
    val wilma: chatter.Member = chatter.join("Wilma")
    val barney: myFace.Member = myFace.join("Barney")

    fred.equals(wilma) should be (true)
    fred.equals(barney) should be (false)

    // fred.contacts += barney  // illegal - other network types
  }
}
