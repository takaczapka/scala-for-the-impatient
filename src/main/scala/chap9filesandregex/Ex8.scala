package chap9filesandregex

/**
 * 8. Write a Scala program that prints the src attributes of all img tags of a web page. Use regular expressions
 * and groups.
 */
object Ex8 {

  // it just parses html string (for easier unit testing)
  // web page can be sucked in a following way:
  //  import scala.io.Source
  //  val html = Source.fromURL("http://google.com")
  //  val s = html.mkString

  val imgPattern = """<img.*src="([\w/:]+)".*>""".r

  def srcOfHtmlImg(s: String): Iterator[String] = {

    imgPattern.findAllIn(s).matchData.map(_.group(1))
  }
}
