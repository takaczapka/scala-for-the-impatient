package chap3arrays

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

/**
 * 10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
 *
 *    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
 *
 * Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get
 * the return value as a Scala buffer. (Why this obscure class? It’s hard to find uses of
 * java.util.List in the standard Java library.)
 */
object Ex10 extends App {

  import scala.collection.JavaConversions._

  val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
  val flavorsList: java.util.List[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)

  println(flavorsList.toBuffer.mkString(","))

  // COMMENT
  // I'm afraid I don't understand "obscurity" question here.
}
