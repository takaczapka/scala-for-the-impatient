package chap9filesandregex

import helpers.FileHelpers
import org.scalatest.{FunSuite, Matchers}

class Ex10Suite extends FunSuite with Matchers {

  import Ex10.Person

  test("serialization of the object graph") {

    val jah = Person("Maciej",
      Array(
        Person("Slawek",
          Array(Person("Lindsey"), Person("Colm"))),
        Person("Marcin",
          Array(Person("Mario")))))

    val f = FileHelpers.createTempFile()

    import java.io._
    val out = new ObjectOutputStream(new FileOutputStream(f))
    out.writeObject(jah)
    out.close()

    val in = new ObjectInputStream(new FileInputStream(f))
    val savedJah = in.readObject().asInstanceOf[Person]

    // a bit of manual checks - arrays can't be tested against equality, which is possible in other sequence types
    jah.name should be (savedJah.name)
    jah.friends.map(_.name) should be (savedJah.friends.map(_.name))
  }
}
