package chap19parsing

import scala.util.parsing.combinator.{JavaTokenParsers, RegexParsers}

/**
  * 6. Assume that the parser in Section 19.5, “Generating Parse Trees,” on page 275 is completed with
  *
  * class ExprParser extends RegexParsers {
  *   def expr: Parser[Expr] = (term ~ opt(("+" | "-") ~ expr)) ^^ {
  *     case a ~ None = > a case a ~ Some(op ~ b) => Operator(op, a, b)
  *   }
  *   ...
  * }
  *
  * Unfortunately, this parser computes an incorrect expression tree— operators with the same precedence
  * are evaluated right-to-left. Modify the parser so that the expression tree is correct. For example, 3-4-5 should
  * yield an Operator("-", Operator("-", 3, 4), 5).
  */
object Ex6 {

  class Expr

  case class Number(value: Int) extends Expr

  case class Operator(op: String, left: Expr, right: Expr) extends Expr

  class ExprParser extends RegexParsers with JavaTokenParsers {
    def expr: Parser[Expr] = (term ~ rep(("+" | "-") ~ term)) ^^ { case t ~ rest =>
      rest.foldLeft(t) { (res, p) => p match {
        case op ~ t1 => Operator(op, res, t1)
      }}
    }

    def term: Parser[Expr] = (factor ~ opt("*" ~> term)) ^^ { case a ~ None => a case a ~ Some(b) => Operator("*", a, b) }

    def factor: Parser[Expr] = wholeNumber ^^ (n => Number(n.toInt)) | "(" ~> expr <~ ")"
  }

}
