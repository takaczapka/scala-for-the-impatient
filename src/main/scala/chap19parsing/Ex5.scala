package chap19parsing

import scala.util.parsing.combinator.RegexParsers
import scala.xml.Node

/**
  * 5. Write a parser that parses a subset of XML. Handle tags of the form < ident > ... </ ident > or < ident/ >.
  * Tags can be nested. Handle attributes inside tags. Attribute values can be delimited by single or double quotes.
  * You don’t need to deal with character data (that is, text inside tags or CDATA sections). Your parser should return
  * a Scala XML Elem value. The challenge is to reject mismatched tags. Hint: into, accept.
  */
object Ex5 {

  // NOTES
  //  * regex in RegexParser can't match on empty string because it will loop forever
  //  * repsep(somewordparser, " ") will not parse "aaaa bbbb aaaa" because RegexParser by default skips spaces (" ")

  class XmlParser extends RegexParsers {

    val identifier = """[a-zA-Z_]\w*""".r
    val anyText = """[^><]+""".r
    val quote = """["']""".r
    val allButSingleQuote = """[^']+""".r
    val allButDoubleQuote = """[^"]+""".r

    def text: Parser[xml.Text] = anyText ^^ { case i => new xml.Text(i) }

    def expr: Parser[xml.Elem] = emptyTag | tag

    def tag: Parser[xml.Elem] = ("<" ~> (identifier ~ attributes) <~ ">") into { case (tag ~ atts) =>
      (nodeSeq ~ ("</" ~> tag <~ ">")
        ^^ { case i ~ _ => xml.Elem(null, tag, atts, xml.TopScope, false, i: _*) })
    }

    def emptyTag: Parser[xml.Elem] = ("<" ~> insideTag <~ "/>") ^^ { case (t, atts) => xml.Elem(null, t, atts, xml.TopScope, false) }

    def insideTag: Parser[(String, xml.MetaData)] = identifier ~ attributes ^^ {
      case i ~ a => (i, a)
    }

    def attributes: Parser[xml.MetaData] = rep((identifier <~ "=") ~
      (quote into {
        case "\"" => allButDoubleQuote <~ "\""
        case "'" => allButSingleQuote <~ "'"
      })) ^^ {
      case l =>
        l.map { case (i ~ v) => new xml.UnprefixedAttribute(i, v, xml.Null) }
    } ^^ {
      case l =>
        l.reverse.fold(xml.Null)((soFar, attr) => soFar append attr)
    }

    def nodeSeq: Parser[List[Node]] = rep(text | expr)
  }

}
