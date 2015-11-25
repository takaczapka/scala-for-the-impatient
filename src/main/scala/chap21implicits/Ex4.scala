package chap21implicits

import scala.language.implicitConversions

/**
  * 4. Some people are fond of “fluent APIs” that read vaguely like English sentences. Create such an API for
  * reading integers, floating-point numbers, and strings from the console.
  * For example:
  *
  * Obtain aString askingFor "Your name" and anInt askingFor "Your age" and aDouble askingFor "Your weight".
  */
object Ex4 extends App {

  // Note: don't see where implicits would be useful here

  trait InputType

  object aString extends InputType

  object anInt extends InputType

  object aDouble extends InputType

  object Obtain {

    private def readLine(text: String): String = Console.readLine(text + ": ")

    trait Ask {
      def askingFor(query: String): Obtain.type
    }

    def in(aType: InputType): Ask = {
      new Ask {
        override def askingFor(query: String): Obtain.type = aType match {
          case t: aString.type => readLine(query); Obtain
          case t: anInt.type => readLine(query).toInt; Obtain
          case t: aDouble.type => readLine(query).toDouble; Obtain
        }
      }
    }

    def and(aType: InputType): Ask = in(aType)
  }

  type Obtain = Obtain.type

  Obtain in aString askingFor "Your name" and anInt askingFor "Your age" and aDouble askingFor "Your weight"
}
