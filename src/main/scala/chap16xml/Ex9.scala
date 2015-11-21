package chap16xml

import scala.xml._
import scala.xml.transform.{RewriteRule, RuleTransformer}

/**
  * 9. Transform an XHTML document by adding an alt ="TODO" attribute to all img elements without an alt attribute,
  * preserving everything else.
  */
object Ex9 {

  val altTODORule = new RewriteRule {

    def enrichImg(e: Node): Node =
      if (e.attribute("alt").isEmpty) e.asInstanceOf[Elem] % Attribute("", "alt", "TODO", Null) else e

    override def transform(n: Node) = n match {
      case e @ <img/> => enrichImg(e)
      case e @ <img>{t}</img> => enrichImg(e)
      case e : Elem => e
      case o : Group => NodeSeq.fromSeq(o.nonEmptyChildren.flatMap(transform))
      case t @ _  => t
    }
  }

  val transformer = new RuleTransformer(altTODORule)

  def altTODOEnrich(xml: Node): Seq[Node] = {
    transformer.transform(xml)
  }
}
