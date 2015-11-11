package chap10traits

/**
 * 4. Provide a CryptoLogger class that encrypts the log messages with the Caesar cipher.
 * The key should be 3 by default, but it should be overridable by the user. Provide usage examples
 * with the default key and a key of –3.
 */
object Ex4 {

  object CesarCipher {
    def encode(s: String, shift: Int) = {
      new String(for (c <- s) yield (c + shift).toChar)
    }
  }

  trait Logger {
    def log(s: String) {}
  }

  trait CryptoLogger extends Logger {

    val shift: Int

    override def log(s: String): Unit = {
      super.log(CesarCipher.encode(s, shift))
    }
  }

  trait PrintLogger extends Logger {
    override def log(s: String): Unit = {
      println(s)
      super.log(s)
    }
  }

}