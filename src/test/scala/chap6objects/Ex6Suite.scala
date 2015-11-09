package chap6objects

import org.scalatest.{FunSuite, Matchers}

class Ex6Suite extends FunSuite with Matchers {

   import Ex6.PlayingCards

   test("fancy playing cards symbols") {

     PlayingCards.HEARTS.toString should be ("♥")
     PlayingCards.DIAMONDS.toString should be ("♦")
     PlayingCards.ClUBS.toString should be ("♣")
     PlayingCards.SPADES.toString should be ("♠")
   }
 }
