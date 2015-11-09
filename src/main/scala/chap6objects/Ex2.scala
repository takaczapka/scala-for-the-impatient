package chap6objects

/**
 * 2. The preceding problem wasn’t very object-oriented. Provide a general superclass
 * UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and MilesToKilometers
 * that extend it.
 */
object Ex2 {

  trait UnitConversion {
    def convert(i: Double): Double
  }

  object InchesToCentimeters extends UnitConversion {
    override def convert(i: Double) = i / 2.54
  }

  object GallonsToLiters extends UnitConversion {
    override def convert(i: Double): Double = i / 3.78
  }

  object MilesToKilometers extends UnitConversion {
    override def convert(i: Double): Double = i / 1.609
  }

}
