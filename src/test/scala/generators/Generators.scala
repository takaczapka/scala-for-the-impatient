package generators

import scala.util.Random

object Generators {

  def anyInt: Int = Random.nextInt()

  def anyPositiveInt: Int = {
    val v = math.abs(anyInt); if (v == 0) 1 else v
  }

  def anyNegativeInt: Int = -anyPositiveInt
}
