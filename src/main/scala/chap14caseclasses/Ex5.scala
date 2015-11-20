package chap14caseclasses

/**
 * 5. One can use lists to model trees that store values only in the leaves. For example, the list (( 3 8) 2 (5))
 * describes the tree
 *      •
 *     /| \
 *    • 2  •
 *   /  \   |
 *   3  8   5
 *
 * However, some of the list elements are numbers and others are lists. In Scala, you cannot have
 * heterogeneous lists, so you have to use a List[ Any]. Write a leafSum function to compute the sum
 * of all elements in the leaves, using pattern matching to differentiate between numbers and lists.
 */
object Ex5 {

  def sum(l: List[Any], acc: Int = 0): Int = {
    l match {
      case (head: Int) :: tail => sum(tail, acc + head)
      case (head: List[Any]) :: tail => sum(tail, acc + sum(head))
      case head :: tail => sum(tail)
      case Nil => acc
    }
  }
}
