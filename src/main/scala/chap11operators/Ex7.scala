package chap11operators

/**
 * 7. Implement a class BitSequence that stores a sequence of 64 bits packed in a Long value.
 * Supply apply and update operators to get and set an individual bit.
 */
object Ex7 {

  class BitSequence(private var l: Long) {

    def update(position: Int, v: Int) = {
      if (v == 0) {
        l &= ~(1l << position)
      } else
        l |= 1l << position
    }

    def apply(position: Int): Long = (l >> position) & 1

    override def toString = l.toBinaryString
  }

}
