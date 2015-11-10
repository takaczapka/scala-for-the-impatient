package chap8inheritance

import org.scalatest.{Matchers, FunSuite, FunSpec}

class Ex9Suite extends FunSuite with Matchers {

  test("uninitialized val makes a superclass initialization fail") {

    class Creature {
      val range: Int = 10
      val env: Array[Int] = new Array[Int](range)
    }

    class Ant extends Creature {
      override val range = 2
    }

    // when ant instance is in creation env initializer calls accessor range() on Ant class which at this
    // point of time is zero (default value of Int). It's because first a super class fields are created.
    new Ant().env should have size 0
  }

  test("avoiding initialization sequence problems with changing val to def") {

    class Creature {
      def range: Int = 10
      val env: Array[Int] = new Array[Int](range)
    }

    class Ant extends Creature {
      override def range = 2
    }

    new Ant().env should have size 2
  }

  test("avoiding initialization sequence problems with making val a lazy val") {

    // NOTE
    // The difference between them is, that a val is executed when it is defined
    // whereas a lazy val is executed when it is accessed the first time.
    class Creature {
      lazy val range: Int = 10
      val env: Array[Int] = new Array[Int](range)
    }

    class Ant extends Creature {
      override lazy val range = 2
    }

    new Ant().env should have size 2
  }

}
