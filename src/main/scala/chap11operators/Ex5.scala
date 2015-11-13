package chap11operators

/**
 * 5. Provide operators that construct an HTML table. For example,
 *
 * Table() | "Java" | "Scala" | | "Gosling" | "Odersky" | | "JVM" | "JVM, .NET"
 *
 * should produce 
 *
 * <table> <tr> <td> Java </td> <td> Scala </td> </tr> <tr> <td> Gosling...
 */
object Ex5 {

  class Table {

    private val current: StringBuffer = new StringBuffer("<table><tr>")

    val trailer = "</tr></table>"

    def |(s: String): Table = {
      current.append("<td>" + s + "</td>")
      this
    }

    def ||(s: String): Table = {
      current.append("</tr><tr>" + "<td>" + s + "</td>")
      this
    }

    override def toString = current + trailer
  }

}
