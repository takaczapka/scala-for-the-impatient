package chap10traits

/**
 * 7. There are dozens of Scala trait tutorials with silly examples of barking dogs or philosophizing frogs.
 * Reading through contrived hierarchies can be tedious and not very helpful, but designing your own is
 * very illuminating. Make your own silly trait hierarchy example example that demonstrates layered traits,
 * concrete and abstract methods, and concrete and abstract fields.
 */
object Ex7 {

  trait Citizen {
    val country: String
  }

  trait Diver {
    def equipment: List[String]
  }

  class ScubaDiver extends Diver {
    override def equipment: List[String] = "mask" :: "fins" :: "bcd" :: "scuba" :: "snorkel" :: Nil
  }

  class FreeDiver extends Diver {
    override def equipment: List[String] = "mask" :: "fins" :: "snorkel" :: Nil
  }

  val maciej = new FreeDiver with Citizen {
    val country = "Poland"
  }
}
