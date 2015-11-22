package chap19parsing

import java.util.{Calendar, Date}

import scala.util.parsing.combinator.RegexParsers

/**
  * 4. Write a parser that can parse date and time expressions in ISO 8601. Your parser should return
  * a java.util.Date object.
  */
object Ex4 {

  class ISO8601DateParser extends RegexParsers {

    val year = """\d\d\d\d""".r
    val month = """\d\d""".r
    val day = """\d\d""".r
    val hour = """\d\d""".r
    val minute = """\d\d""".r
    val second = """\d\d""".r


    def expr: Parser[Date] = year ~ opt(monthToken ~ opt(dayToken)) ~ opt(hourToken ~ opt(minuteToken ~ opt(secondToken))) ^^ {
      case y ~ None ~ t => (Seq(y.toInt, 1, 1), t)
      case y ~ Some(m ~ None) ~ t => (Seq(y.toInt, m, 1), t)
      case y ~ Some(m ~ Some(d)) ~ t => (Seq(y.toInt, m, d), t)
    } ^^ {
      case (d, None) => d ++ Seq(0, 0, 0)
      case (d, Some(h ~ None)) => d ++ Seq(h, 0, 0)
      case (d, Some(h ~ Some(m ~ None))) => d ++ Seq(h, m, 0)
      case (d, Some(h ~ Some(m ~ Some(s)))) => d ++ Seq(h, m, s)
    } ^^ {
      case Seq(y, m, d, h, min, s) =>
        val calendar = Calendar.getInstance
        calendar.set(y.toInt, m.toInt - 1, d.toInt, h, min, s)
        new Date(calendar.getTimeInMillis)
    }

    def monthToken: Parser[Int] = opt("-") ~> month ^^ {
      _.toInt
    }

    def dayToken: Parser[Int] = opt("-") ~> day ^^ {
      _.toInt
    }

    def hourToken: Parser[Int] = opt(" " | "T") ~> hour ^^ {
      _.toInt
    }


    def minuteToken: Parser[Int] = opt(":") ~> minute ^^ {
      _.toInt
    }

    def secondToken: Parser[Int] = opt(":") ~> second ^^ {
      _.toInt
    }
  }

}
