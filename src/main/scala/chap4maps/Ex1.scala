package chap4maps

/**
 * 1. Set up a map of prices for a number of gizmos that you covet. Then produce
 * a second map with the same keys and the prices at a 10 percent discount.
 */
object Ex1 {

  def discount(items: Map[String, Double]): Map[String, Double] =
    items.map { case (n, p) => n -> p * 0.9 }
}
