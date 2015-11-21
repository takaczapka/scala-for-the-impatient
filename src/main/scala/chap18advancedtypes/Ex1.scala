package chap18advancedtypes

/**
  * 1. Implement a Bug class modeling a bug that moves along a horizontal line. The move method moves in the current
  * direction, the turn method makes the bug turn around, and the show method prints the current position. Make these
  * methods chainable. For example,
  *
  * bugsy.move(4).show().move(6).show().turn().move(5).show()
  *
  * should display 4 10 5.
  */
object Ex1 extends App {

  class Bug {

    private var _position: Int = 0
    private var _goingRight = true

    def move(i: Int): this.type = {
      if (_goingRight) _position = _position + i
      else _position = _position - i
      this
    }

    def turn(): this.type = {
      _goingRight = !_goingRight
      this
    }

    def show(): this.type = {
      print(_position + " ")
      this
    }

    def position: Int = _position
  }

  val bugsy = new Bug()
  bugsy.move(4).show().move(6).show().turn().move(5).show()
}
