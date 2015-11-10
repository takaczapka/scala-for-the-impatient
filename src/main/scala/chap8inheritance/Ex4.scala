package chap8inheritance

import scala.collection.mutable

/**
 * 4. Define an abstract class Item with methods price and description. A SimpleItem is an item whose price
 * and description are specified in the constructor. Take advantage of the fact that a val can override a def.
 * A Bundle is an item that contains other items. Its price is the sum of the prices in the bundle. Also provide
 * a mechanism for adding items to the bundle and a suitable description method.
 */
object Ex4 {

  abstract class Item {
    def price: Double

    def description: String
  }

  class SimpleItem(val price: Double, val description: String) extends Item

  class Bundle(_items: Array[Item]) extends Item {

    private val items: mutable.Seq[Item] = mutable.Seq.empty[Item] ++ _items

    override def price: Double = items.map(_.price).sum

    override def description = items.foldLeft("Items: ")((z, item) => z + "\n\t" + item.description)
  }

}
