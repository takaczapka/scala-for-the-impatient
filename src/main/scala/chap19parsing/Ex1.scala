package chap19parsing

import scala.util.parsing.combinator.RegexParsers

/**
  * 1. Add / and % operations to the arithmetic expression evaluator.
  */
object Ex1 {

  class ExprParser extends RegexParsers {

    val number = "-?[0-9]+".r

    def factor: Parser[Int] = number ^^ {
      _.toInt
    } | "(" ~ expr ~ ")" ^^ { case _ ~ e ~ _ => e }

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {
      case "+" ~ t => t
      case "-" ~ t => -t
    }) ^^ {
      case t ~ r => t + r.sum
    }

    def term: Parser[Int] = factor ~ rep(("*" | "/" | "%") ~ factor) ^^ {
      case f ~ r =>
        r.foldLeft(f) {
          case (res, op ~ v) => op match {
            case "*" => res * v
            case "/" => res / v
            case "%" => res % v
          }
        }
    }
  }

}
