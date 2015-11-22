package chap19parsing

import org.scalatest.{FunSuite, Matchers}

import scala.xml.Elem

class Ex5Suite extends FunSuite with Matchers {

  import Ex5._

  val parser = new XmlParser()

  def parse(s: String): Elem = {
    parser.parseAll(parser.expr, s).get
  }

  test("xml parsing") {

    parse("<a/>") should be (<a/>)
    parse("<aa></aa>") should be (<aa></aa>)
    parse("<aa>some text</aa>") should be (<aa>some text</aa>)
    parse("<aa>aa<b>a<c></c></b><d/></aa>") should be (<aa>aa<b>a<c></c></b><d/></aa>)
    parse("""<aab a1="asdasd"/>""") should be (<aab a1="asdasd"/>)
    parse("""<aab a1="asdasd" a2='asdas'/>""") should be (<aab a1="asdasd" a2="asdas"/>)
    parse("""<aab a1="asdasd" a2="12121 'aaa'"/>""") should be (<aab a1="asdasd" a2="12121 'aaa'"/>)
  }
}
