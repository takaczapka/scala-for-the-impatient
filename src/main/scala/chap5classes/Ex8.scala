package chap5classes

/**
 * 8. Make a class Car with read-only properties for manufacturer, model name, and model year, and a read-write property
 * for the license plate. Supply four constructors. All require the manufacturer and model name. Optionally, model year
 * and license plate can also be specified in the constructor. If not, the model year is set to -1 and the license plate
 * to the empty string. Which constructor are you choosing as the primary constructor? Why?
 */
object Ex8 {

  class Car(val manufacturer: String, val model: String, val year: Int, var licencePlate: String) {

    def this(manufacturer: String, model: String, year: Int) {
      this(manufacturer, model, year, "")
    }

    def this(manufacturer: String, model: String) {
      this(manufacturer, model, -1, "")
    }
  }

  // ANSWER
  // Primary constructor should initialize all parameters, hence the "widest" is the only option.
}
