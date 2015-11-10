package chap7packages

/**
 * 6. Write a program that copies all elements from a Java hash map into a Scala hash map.
 * Use imports to rename both classes.
 */
object Ex6 {

  import java.util.{HashMap => JavaHashMap}
  import collection.mutable.{HashMap => ScalaHashMap}
  import collection.JavaConversions._

  def copy[K, V](source: JavaHashMap[K, V]): ScalaHashMap[K, V] = {
    val dest = new ScalaHashMap[K, V]()
    source.foreach { case (k, v) => dest.update(k, v) }
    dest
  }
}
