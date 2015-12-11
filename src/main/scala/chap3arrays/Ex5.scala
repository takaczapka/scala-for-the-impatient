package chap3arrays

/**
  * 5. How do you compute the average of an Array[ Double]?
  */
object Ex5 {

  def avg(a: Array[Double]): Double = {
    a.sum / a.length
  }
}
