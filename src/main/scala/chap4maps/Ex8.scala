package chap4maps

/**
 * 8. Write a function minmax(values: Array[Int]) that returns a pair containing
 * the smallest and largest values in the array.
 */
object Ex8 {

  def minmax(values: Array[Int]): (Int, Int) = {
    assert(values.nonEmpty)

    (values.min, values.max)
  }
}
