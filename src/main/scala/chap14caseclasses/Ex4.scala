package chap14caseclasses

/**
  * 4. Add a case class Multiple that is a subclass of the Item class. For example,
  * Multiple( 10, Product(" Blackwell Toaster", 29.95)) describe describes ten toasters. Of course, you should be able
  * to handle any items, such as bundles or multiples, in the second argument. Extend the price function to handle this
  * new case.
  */
object Ex4 {

  abstract class Item

  case class Bundle(description: String, discount: Double, items: Item*) extends Item

  case class Multiple(amount: Int, item: Item, price: Double)

}
