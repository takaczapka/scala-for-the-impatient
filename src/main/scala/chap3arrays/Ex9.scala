package chap3arrays

/**
 * 9. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America.
 * Strip off the "America/" prefix and sort the result.
 */
object Ex9 extends App {

  val timezones: Array[String] = java.util.TimeZone.getAvailableIDs
  timezones.map(s => s.replaceFirst("^America/", "")).foreach {
    println
  }
}
