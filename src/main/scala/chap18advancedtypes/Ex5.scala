package chap18advancedtypes

/**
  * 5. Consider the type alias
  *
  * type NetworkMember = n.Member forSome { val n: Network }
  *
  * and the function
  *
  * def process(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
  *
  * How does this differ from the process function in Section 18.8, “Existential Types,” on page 252?
  */
object Ex5 extends App {

  import Ex4._


  val chatter = new Network
  val myFace = new Network

  val fred: chatter.Member = chatter.join("Fred")
  val wilma: chatter.Member = chatter.join("Wilma")
  val barney: myFace.Member = myFace.join("Barney")


  def process1[M <: n.Member forSome {val n : Network}](m1: M, m2: M) = (m1, m2)

  process1(fred, wilma)
  //  process1(fred, barney) // illegal, will not compile

  type NetworkMember = n.Member forSome {val n: Network}

  def process2(m1: NetworkMember, m2: NetworkMember) = (m1, m2)

  // process2 operates on any kind of Member instance of Network type, so it's not only
  // limited to the members of the same Network
  process2(fred, barney)
}
