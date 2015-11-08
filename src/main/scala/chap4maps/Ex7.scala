package chap4maps

import java.util

/**
 * 7. Print a table of all Java properties, like this:
 * property-long-name | value
 * property           | value2
 */
object Ex7 extends App {

  import scala.collection.JavaConversions._

  def tabbedOutput(m: Map[String, String]): String = {
    if (m.isEmpty) ""
    else {
      val max = m.keys.map(_.length).max

      m.map { case (k, v) =>
        val fillSpaces = " " * (max - k.length)
        k + fillSpaces + " | " + v
      }.mkString("\n")
    }
  }


  val props = System.getProperties
  val keys: util.Set[String] = props.keySet() map (_.toString)
  val propertyMap = keys.map(n => n -> props.getProperty(n)).toMap

  println(tabbedOutput(propertyMap))
}
