package chap6objects

/**
 * 3. Define an Origin object that extends java.awt.Point. Why is this not actually a good idea?
 * (Have a close look at the methods of the Point class).
 */
object Ex3 extends App {

  object Origin extends java.awt.Point

  // ANSWER
  // Origin is a singleton, but it's state is mutable which means any client code can change the location of
  // the Origin.
}
