package chap19parsing

import scala.util.parsing.combinator.RegexParsers

/**
  * 2. Add a ^ operator to the arithmetic expression evaluator. As in mathematics, ^ should have a higher precedence
  * than multiplication, and it should be right-associative. That is, 4 ^ 2 ^ 3 should be 4 ^( 2 ^ 3), or 65536.
  */
object Ex2 {

  class ExprParser extends RegexParsers {
    val number = "-?[0-9]+".r

    def factor: Parser[Int] = number ^^ {
      _.toInt
    } | "(" ~> expr <~ ")"

    def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {
      case "+" ~ t => t
      case "-" ~ t => -t
    }) ^^ {
      case t ~ r => t + r.sum
    }

    def term: Parser[Int] = pow ~ rep(("*" | "/" | "%") ~ pow) ^^ {
      case f ~ r =>
        r.foldLeft(f) {
          case (res, op ~ v) => op match {
            case "*" => res * v
            case "/" => res / v
            case "%" => res % v
          }
        }
    }

    def pow: Parser[Int] = factor ~ rep("^" ~ factor ^^ { case _ ~ r => r }) ^^ {
      case f ~ r =>
        (f :: r).reduceRight((a, b) => Math.pow(a, b).toInt)
    }
  }
}
