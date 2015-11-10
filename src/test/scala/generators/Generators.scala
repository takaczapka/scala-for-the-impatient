package generators

import scala.util.Random

object Generators {

  def anyInt: Int = Random.nextInt()

  def anyPositiveInt: Int = {
    val v = math.abs(anyInt); if (v == 0) 1 else v
  }

  def anyNegativeInt: Int = -anyPositiveInt

  def anyDouble: Double = Random.nextDouble()

  def anyPositiveDouble: Double = {
    val v = math.abs(anyInt)
    if (v == 0.0) 1.0 else v
  }

  def anyChar: Char = anyInt.toChar
}
