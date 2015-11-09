package chap6objects

/**
 * 1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and milesToKilometers.
 */
object Ex1 {

  object Conversions {

    def inchesToCentimeters(i: Double) = i / 2.54

    def gallonsToLiters(g: Double) = g / 3.78

    def milesToKilometers(m: Double) = m / 1.609
  }
}
