package chap16xml

import scala.xml.Node

/**
  * 7. Write a function that has a parameter of type Map[String, String], and returns a dl element with a dt for each
  * key and dd for each value.
  *
  * For example, Map(" A" -> "1", "B" -> "2")
  *
  * should yield
  *
  * <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>.
  */
object Ex7 {

  def toTable(m: Map[String, String]): Node = {
    <dl>{for ((k, v) <- m) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
  }
}
