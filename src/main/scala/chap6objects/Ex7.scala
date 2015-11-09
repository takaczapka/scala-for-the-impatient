package chap6objects

/**
 * 7. Implement a function that checks whether a card suit value from the preceding exercise is red.
 */
object Ex7 {

  import Ex6.PlayingCards._

  def isHearts(cardSuite: PlayingCards) = cardSuite == HEARTS
}
