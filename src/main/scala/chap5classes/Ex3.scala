package chap5classes

/**
 * 3. Write a class Time with read-only properties hours and minutes and a method before(other: Time): Boolean
 * that checks whether this time comes before the other. A Time object should be constructed as new Time(hrs, min),
 * where hrs is in military time format (between 0 and 23).
 */
object Ex3 {

  object Time {
    def apply(hrs: Int, min: Int): Time = new Time(hrs, min)
  }

  class Time(_hrs: Int, _min: Int) {

    require(_hrs >= 0 && _hrs < 24, "hour format is not allowed")
    require(_min >= 0 && _min < 60, "min format is not allowed")

    private val timeInMin = _hrs * 60 + _min

    def before(t: Time): Boolean = {
      if (timeInMin < t.timeInMin) true
      else false
    }
  }

}
