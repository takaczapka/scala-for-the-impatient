package chap18advancedtypes

/**
  * 4. Implement the equals method for the Member class that is nested inside the Network class in Section 18.2,
  * “Type Projections,” on page 247. For two members to be equal, they need to be in the same network.
  */
object Ex4 {

  import scala.collection.mutable.ArrayBuffer

  class Network {

    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]

      // an attempt of calling equals on members from distinct networks will delegate to Object.equals,
      // hence it's enough to simply return true here
      def equals(that: Member): Boolean = {
        true
      }
    }

    private val members = new ArrayBuffer[Member]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }

}
