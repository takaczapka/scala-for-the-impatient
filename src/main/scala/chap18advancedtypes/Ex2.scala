package chap18advancedtypes

import chap18advancedtypes.Ex1.Bug

/**
  * 2. Provide a fluent interface for the Bug class of the preceding exercise, so that one can write
  *
  * bugsy move 4 and show and then move 6 and show turn around move 5 and show
  */
object Ex2 extends App {

  object And

  object Then

  object Around

  object Show

  val and = And
  val then = Then
  val show = Show
  // need this one as can't do infix with no-param func
  val around = Around

  trait FluentBug {
    this: Bug =>

    def and(s: Show.type): this.type = this.show()

    def and(t: Then.type): this.type = this

    def turn(a: Around.type): this.type = this.turn()
  }

  val bugsy = new Bug with FluentBug
  bugsy move 4 and show and then move 6 and show turn around move 5 and show
}
