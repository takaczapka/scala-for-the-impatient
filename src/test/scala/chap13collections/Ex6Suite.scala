package chap13collections

import org.scalatest.{FunSuite, Matchers}

class Ex6Suite extends FunSuite with Matchers {


  test("reverse with folds") {

    def revRight(lst: List[Int]) = {
      //      (lst :\ List[ Int]())(_ :: _)
      (lst :\ List[Int]())((el, list) => list :+ el)
    }

    def revLeft(lst: List[Int]) = {
      //      (List[ Int]() /: lst)(_ :+ _)
      (List[Int]() /: lst)((list, el) => el :: list)
    }

    val l = List(1, 2, 3, 4, 5, 6)
    val expected = l.reverse

    revRight(l) should be(expected)
    revLeft(l) should be(expected)

    // Note revLeft is more efficient as it expands the list in constant time, while revRight adds to the end of
    // the list which is linear.
  }

  test("making sure I understand foldRight operator") {
    val lst = List(1, 2, 3)

    lst.foldRight(List[Int](5, 6, 7))(_ :: _) should be(List(1, 2, 3, 5, 6, 7))

    lst.foldRight(List[Int](5, 6, 7))(_ :: _) should be((lst :\ List[Int](5, 6, 7))(_ :: _))
  }

  test("making sure I understand foldLeft operator") {
    val lst = List(1, 2, 3)

    lst.foldLeft(List[Int](5, 6, 7))(_ :+ _) should be(List(5, 6, 7, 1, 2, 3))
    (List[Int](5, 6, 7) /: lst)(_ :+ _) should be(List(5, 6, 7, 1, 2, 3))
  }
}
