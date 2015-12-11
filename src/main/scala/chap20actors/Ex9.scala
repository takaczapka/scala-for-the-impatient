package chap20actors

/**
  * 9. Produce a faulty implementation of the program in exercise 3, in which the actors update a shared counter.
  * Can you demonstrate that the program acts incorrectly?
  */
object Ex9 {

  // IGNORING. It's generally not safe for multiple threads accessing a shared variable, and actors are
  // run by multiple threads, so by definition it's a risky business.
}
