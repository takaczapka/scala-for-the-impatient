package chap13collections

import scala.collection.mutable

/**
 * 3. Write a function that removes all zeroes from a linked list of integers.
 */
object Ex3 {

  // I understand I have to use mutable.LinkedList here

  def removeZeros(input: mutable.LinkedList[Int]): mutable.LinkedList[Int] = {

    // can't return a reference to input list as the first elem might be zero so we would lose a reference to the list
    
    // removing trailing zeros
    var nonZeroPointer = input
    while (nonZeroPointer != mutable.LinkedList() && nonZeroPointer.elem == 0) nonZeroPointer = nonZeroPointer.next

    var cur = nonZeroPointer
    while (cur != mutable.LinkedList() && cur.next != mutable.LinkedList()) {
      if (cur.next.elem == 0) cur.next = cur.next.next
      else cur = cur.next
    }

    nonZeroPointer
  }
}
