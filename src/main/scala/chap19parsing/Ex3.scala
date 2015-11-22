package chap19parsing

import scala.util.parsing.combinator.RegexParsers

/**
  * 3. Write a parser that parses a list of integers (such as (1, 23, -79)) into a List[ Int].
  */
object Ex3 {

  class IntParser extends RegexParsers {
    val number = "-?[0-9]+".r

    def expr: Parser[List[Int]] = "(" ~> repsep(number, ",") <~ ")" ^^ {
      _.map(_.toInt)
    }
  }

}
