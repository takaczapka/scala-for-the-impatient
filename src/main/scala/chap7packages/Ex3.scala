package chap7packages

/**
 * 3. Write a package random with functions nextInt(): Int, nextDouble(): Double, and setSeed( seed: Int): Unit.
 * To generate random numbers, use the linear congruential generator
 *
 * next = previous × a + b mod 2^^n, where a = 1664525, b = 1013904223, and n = 32.
 */
object Ex3 extends App {
  for (i <- 0 to 100) println(random.nextInt())
}

package object random {

  val (a, b, n) = (1664525, 1013904223, 32)
  private var previous: Double = 1

  def nextInt(): Int = (nextDouble() % Int.MaxValue).toInt

  def nextDouble(): Double = {
    previous = (previous * a) + (b % math.pow(2, n)) % Double.MaxValue
    if (previous == Double.NegativeInfinity || previous == Double.PositiveInfinity) {
      previous = 1; previous = nextDouble()
    }
    previous
  }

  def setSeed(seed: Int): Unit = {}
}
