package chap16xml

import scala.xml.Node

/**
  * 8. Write a function that takes a dl element and turns it into a Map[String, String]. This function should be
  * the inverse of the function in the preceding exercise, provided all dt children are distinct.
  */
object Ex8 {

  def toMap(m: Node): Map[String, String] = {
    m.child.collect {
      case <dt>{k}</dt> => k.text
      case <dd>{v}</dd> => v.text
    }.grouped(2).collect { case Seq(a, b) => a -> b }.toMap
  }
}
