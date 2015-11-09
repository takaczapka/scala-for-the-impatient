package chap6objects

/**
 * 6. Write an enumeration describing the four playing card suits so that the toString method returns ♣, ♦, ♥, or ♠.
 */
object Ex6 {

  object PlayingCards extends Enumeration {

    type PlayingCards = Value

    val SPADES = Value("\u2660")
    val DIAMONDS = Value("\u2666")
    val HEARTS = Value("\u2665")
    val ClUBS = Value("\u2663")
  }
}
