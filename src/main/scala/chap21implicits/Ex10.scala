package chap21implicits

import scala.collection.immutable.IndexedSeq

/**
  * 10. The result of "abc".map(_.toUpper) is a String, but the result of "abc".map(_.toInt) is a Vector.
  * Find out why.
  */
object Ex10 {

  // definition of Map
  //  def map[B, That](f: A => B)(implicit bf: CanBuildFrom[Repr, B, That]): That
  //
  // in case of String it becomes more or less:
  //  def map[B, That](f: Char => B)(implicit bf: CanBuildFrom[String, B, That]): That

  // when the map function if _.toChar in  "abc".map(_.toChar)
  // it becomes
  // def map[Char, That](f: Char => Char)(implicit bf: CanBuildFrom[String, Char, That]): That

  // Predef has
  //  implicit val StringCanBuildFrom: CanBuildFrom[String, Char, String]
  // and this is the best match to applied in this case to "abc".map(_.toChar)

  // in case of "abc".map(_.toInt) there's no defined implicit of type CanBuildFrom[String, Int, ?]
  // so the best match is Predef's
  // implicit def fallbackStringCanBuildFrom[T]: CanBuildFrom[String, T, immutable.IndexedSeq[T]]
  // hence  "abc".map(_.toInt) result is of type IndexedSeq[Int]


  val a: IndexedSeq[Int] = "abc".map(_.toInt)
  val b: String = "abc".map(_.toChar)
}
