package chap9filesandregex

import java.io.Serializable

/**
 * 10. Expand the example with the serializable Person class that stores a collection of friends.
 * Construct a few Person objects, make some of them friends of another, and then save an Array[ Person]
 * to a file. Read the array back in and verify that the friend relations are intact.
 */
object Ex10 {

  @SerialVersionUID(42L)
  case class Person(val name: String, val friends: Array[Person] = Array.empty) extends Serializable
}
