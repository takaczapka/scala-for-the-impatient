package chap17typeparams

/**
  * 6. Write a generic method middle that returns the middle element from any Iterable[ T]. For example,
  * middle("World") is 'r'.
  */
object Ex6 {

  // ! Manifest! to create an array...
  def middle[T : Manifest](i: Iterable[T]): T = {
    val a: Array[T] = i.toArray
    assert(a.length > 0)
    a(a.length/2)
  }

  println(middle(Seq(1, 2, 23)))
  println(middle(List(1, 2, 23)))
  println(middle(List(9)))
}
