package chap4maps

/**
 * 9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values
 * less than v, equal to v, and greater than v.
 */
object Ex9 {

  def lteqgt(values: Array[Int], v: Int) = {
    val m: Map[String, Array[Int]] = values.groupBy {
      case i if i < v => "lw"
      case i if i == v => "eq"
      case i if i > v => "gt"
    }

    (m.getOrElse("lw", Array()).length,
      m.getOrElse("eq", Array()).length,
      m.getOrElse("gt", Array()).length)
  }
}
