package chap14caseclasses

/**
 * 9. Write a function that computes the sum of the non-None values in a List[ Option[ Int]]. Don’t use a match
 * statement.
 */
object Ex9 {

  def sum(list: List[Option[Int]]) = list.flatten.sum
}
