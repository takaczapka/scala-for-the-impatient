package chap19parsing

import scala.util.parsing.combinator.syntactical.StandardTokenParsers

/**
  * 10. Add function definitions to the programming language of the preceding exercise.
  */
object Ex10 {

  case class Context(vars: collection.immutable.Map[String, Int] = Map.empty,
                     functions: collection.immutable.Map[String, AppFunction] = Map.empty,
                     result: Option[Int] = None) {

    def dropTheVars: Context = copy(vars = Map.empty)

    def varValue(name: String): Int = vars.getOrElse(name, 0)

    def funcCall(name: String): Option[Int] = {
      functions.get(name) match {
        case Some(f) => f.evaluate(dropTheVars).result
        case None => throw new RuntimeException(s"Function [$name] not found.")
      }
    }
  }

  abstract class Expr {
    def value(c: Context): Int
  }

  case class Number(value: Int) extends Expr {
    def value(c: Context) = value
  }

  case class Operator(op: String, left: Expr, right: Expr) extends Expr {
    def value(c: Context) = op match {
      case "+" => left.value(c) + right.value(c)
      case "-" => left.value(c) - right.value(c)
      case "*" => left.value(c) * right.value(c)
      case "/" => left.value(c) / right.value(c)
      case "%" => left.value(c) % right.value(c)
      case "^" => math.pow(left.value(c), right.value(c)).toInt
    }
  }

  case class Var(name: String) extends Expr {
    override def value(c: Context): Int = c.varValue(name)
  }

  case class FunctionCall(name: String) extends Expr {
    override def value(c: Context): Int = {
      c.funcCall(name).getOrElse {
        throw new RuntimeException(s"Function: [$name] doesn't return a value")
      }
    }
  }

  abstract class CodeBlock {
    def evaluate(c: Context): Context
  }

  case class LineExpression(expr: Expr) extends CodeBlock {
    override def evaluate(c: Context): Context = c.copy(result = Some(expr.value(c)))
  }

  case class Assignment(variable: Var, expr: Expr) extends CodeBlock {
    override def evaluate(c: Context): Context = {
      if (variable.name == "out") {
        println(expr.value(c))
        c
      } else {
        c.copy(vars = c.vars + (variable.name -> expr.value(c)), result = None)
      }
    }
  }

  case class Condition(op: String, left: Expr, right: Expr) {
    def value(c: Context): Boolean = op match {
      case "<" => left.value(c) < right.value(c)
      case "<=" => left.value(c) <= right.value(c)
      case "==" => left.value(c) == right.value(c)
      case ">=" => left.value(c) >= right.value(c)
      case ">" => left.value(c) > right.value(c)
      case "!=" => left.value(c) != right.value(c)
    }
  }

  case class IfElse(condition: Condition, statements: List[CodeBlock], elseStatements: Option[List[CodeBlock]]) extends CodeBlock {
    override def evaluate(c: Context): Context = {
      val newContext = if (condition.value(c)) {
        statements.foldLeft(c) {
          case (context, expr) => expr.evaluate(context)
        }
      } else {
        if (elseStatements.isDefined) {
          elseStatements.get.foldLeft(c) {
            case (context, expr) => expr.evaluate(context)
          }
        } else c
      }
      newContext
    }
  }

  case class WhileLoop(condition: Condition, statements: List[CodeBlock]) extends CodeBlock {
    def evaluateWhileBody(c: Context): Context = {
      statements.foldLeft(c) {
        case (context, expr) => expr.evaluate(context)
      }
    }

    override def evaluate(c: Context): Context = {
      var newContext = c  // TODO get rid of this var
      while (condition.value(newContext)) {
        newContext = evaluateWhileBody(newContext)
      }
      newContext
    }
  }

  case class Application(main: Main, functions: List[AppFunction] = Nil) {
    def run(): Option[Int] = {
      main.evaluate(Context(functions = functions.map(f => f.name -> f).toMap)).result
    }
  }

  case class Main(body: Body) extends CodeBlock {
    override def evaluate(c: Context): Context = body.evaluate(c)
  }

  case class AppFunction(name: String, body: Body) extends CodeBlock {
    override def evaluate(c: Context): Context = body.evaluate(c)

  }

  case class Body(expressions: List[CodeBlock]) extends CodeBlock {
    override def evaluate(c: Context): Context = expressions.foldLeft(c) {
      case (context, expr) => expr.evaluate(context)
    }
  }

  class ExprParser extends StandardTokenParsers {
    val varMap = collection.mutable.Map[String, Int]()

    lexical.delimiters +=("=", "+", "-", "*", "^", "%", "/", ";", "(", ")", "{", "}", "<", ">", "==", ">=", "<=", "!=")
    lexical.reserved +=("main", "func", "if", "else", "while")


    def application: Parser[Application] = rep(function) ~ main ~ rep(function) ^^ {
      case f1 ~ m ~ f2 => Application(m, f1 ::: f2)
    }

    def main: Parser[Main] = "main" ~> "{" ~> body <~ "}" ^^ {
      case b => Main(b)
    }

    def function: Parser[AppFunction] = ("func" ~> ident <~ "(" <~ ")") ~ ("{" ~> body <~ "}") ^^ {
      case (i ~ b) => AppFunction(i, b)
    }

    def body: Parser[Body] = opt(langExpression ~ rep(langExpression) ^^ {
      case a ~ r => Body(a :: r)
    }) ^^ {
      case Some(b) => b
      case None => Body(List.empty)
    }

    def langExpression[LangExpression] = assignment | ifElse | whileLoop | lineExpression

    def lineExpression[LineExpression] = expr <~ ";" ^^ { case e => LineExpression(e) }

    def assignment: Parser[Assignment] = (variable <~ "=") ~ expr <~ ";" ^^ { case i ~ e => Assignment(i, e) }

    def ifElse: Parser[CodeBlock] = ("if" ~> "(" ~> condition <~ ")") ~ ("{" ~> body <~ "}") ~ opt("else" ~> "{" ~> body <~ "}") ^^ {
      case c ~ p ~ a => IfElse(c, p.expressions, a.map {
        _.expressions
      })
    }

    def whileLoop: Parser[CodeBlock] = ("while" ~> "(" ~> condition <~ ")") ~ ("{" ~> body <~ "}") ^^ {
      case c ~ p => WhileLoop(c, p.expressions)
    }

    def condition: Parser[Condition] = expr ~ ("<" | ">" | "==" | ">=" | "<=" | "!=") ~ expr ^^ {
      case e1 ~ op ~ e2 => Condition(op, e1, e2)
    }

    def expr: Parser[Expr] = term ~ rep(("+" | "-") ~ term) ^^ {
      case t ~ r => r.foldLeft(t) { case (c, (op ~ e)) => Operator(op, c, e) }
    }

    def term: Parser[Expr] = termPow ~ rep(("*" | "/" | "%") ~ termPow) ^^ {
      case t ~ r => r.foldLeft(t) { case (c, (op ~ e)) => Operator(op, c, e) }
    }

    def termPow: Parser[Expr] = factor ~ rep("^" ~> factor) ^^ {
      case t ~ r => r.foldLeft(t) { case (c, e) => Operator("^", c, e) }
    }

    def factor: Parser[Expr] = number | "(" ~> expr <~ ")" | functionCall | variable

    def number: Parser[Number] = opt("-") ~ numericLit ^^ {
      case Some(_) ~ i => Number(-i.toInt)
      case None ~ i => Number(i.toInt)
    }

    def variable: Parser[Var] = ident ^^ { case v => Var(v) }

    def functionCall: Parser[FunctionCall] = ident <~ "(" <~ ")" ^^ { case fc => FunctionCall(fc) }

    def parseAll[T](p: Parser[T], in: String): ParseResult[T] = phrase(p)(new lexical.Scanner(in))
  }

}
