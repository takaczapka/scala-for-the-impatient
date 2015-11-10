package chap7packages

/**
 * 5. What is the meaning of
 *  private[com] def giveRaise(rate: Double)?
 *  Is it useful?
 */
object Ex5 {
  // ANSWER
  // That means that function giveRaise will be only visible in the package com and it's subpackages. Might be useful,
  // but personally I think that it might complicate the code a bit. I like simple encapsulation rules.
}
