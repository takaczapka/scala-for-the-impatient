package chap11operators

/**
 * 6. Provide a class ASCIIArt whose objects contain figures such as
 * /\_/\
 * ( ' ' )
 * ( - )
 * | | |
 * (__|__)
 *
 * Supply operators for combining two ASCIIArt figures horizontally
 * /\_/\     -----
 * ( ' ' )  / Hello \
 * ( - )  < Scala  |
 * | | |   \ Coder /
 * (__|__)    -----
 *
 * or vertically. Choose operators with appropriate precedence.
 */
object Ex6 extends App {

  object AsciiShape {
    def apply(s: String*) = new AsciiShape(s.toSeq)
  }

  class AsciiShape(_shape: Seq[String], linesOfShapes: Seq[Seq[String]] = Seq.empty) {
    val width = _shape.map(_.length).max
    val height = _shape.length

    val shape: Seq[String] = _shape.map {
      s =>
        s + (" " * (width - s.length))
    }

    def +(that: AsciiShape): AsciiShape = {
      assert(this.height == that.height)

      val combinedShape: Seq[String] = this.shape.zip(that.shape).map { case (l, r) => l + r }
      new AsciiShape(combinedShape, this.linesOfShapes)
    }

    def -(that: AsciiShape): AsciiShape = {
      new AsciiShape(that.shape, this.linesOfShapes :+ this.shape)
    }

    override def toString = (this.linesOfShapes :+ this.shape).map(_.mkString("\n")).mkString("\n")
  }

  val s1 = AsciiShape(
    """ /\_/\ """,
    """( ' ' )""",
    """ /\_/\ """,
    """ /\_/\ """,
    """ /\_/\ """)

  val s2 = AsciiShape(
    """ /\_/\ """,
    """( ' ' )""",
    """(  -  )""",
    """ | | | """,
    """(__|__)""")

  val s3 = AsciiShape(
    """  -----  """,
    """ /     \ """,
    """<  YO!  |""",
    """ \     / """,
    """  -----  """)

  println(s1 + s2 + s3 + s2 + s1 - s3 + s2 - s1)

}
