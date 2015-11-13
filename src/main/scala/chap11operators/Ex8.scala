package chap11operators

/**
 * 8. Provide a class Matrix— you can choose whether you want to implement 2 × 2 matrices, square matrices of any size,
 * or m × n matrices. Supply operations + and *. The latter should also work with scalars, for example mat * 2.
 * A single element should be accessible as mat( row, col).
 */
object Ex8 {

  case class Matrix(m: Array[Array[Int]]) {

    val nrows = m.length
    val ncols = m(0).length

    assert(m.length > 0)
    assert(ncols > 0)
    for (c <- m) assert(c.length == ncols)

    def apply(x: Int)(y: Int): Int = m(x)(y)


    def +(that: Matrix): Matrix = {
      assert(this.nrows == that.nrows)
      assert(this.ncols == that.ncols)

      val result: Array[Array[Int]] = Array.ofDim(nrows, ncols)

      for (r <- 0 until nrows; c <- 0 until ncols) {
        result(r)(c) = this (r)(c) + that(r)(c)
      }

      new Matrix(result)
    }

    def *(that: Matrix): Matrix = {
      assert(this.ncols == that.nrows)


      val result: Array[Array[Int]] = Array.ofDim(nrows, that.ncols)

      for (i <- 0 until this.nrows; k <- 0 until that.ncols) {
        result(i)(k) = (for (j <- 0 until this.ncols) yield this (i)(j) * that(j)(k)).sum
      }

      new Matrix(result)
    }

    def *(scalar: Int): Matrix = {

      val result: Array[Array[Int]] = Array.ofDim(nrows, ncols)

      for (i <- 0 until nrows; k <- 0 until ncols) {
        result(i)(k) = this (i)(k) * scalar
      }

      new Matrix(result)
    }

    override def equals(that: Any): Boolean = that match {
      case thatM : Matrix => this.m.deep == thatM.m.deep
      case _ => false
    }

    override def hashCode(): Int = m.deep.hashCode()

    override def toString = m.map(_.mkString(" ")).mkString("\n")
  }

}
