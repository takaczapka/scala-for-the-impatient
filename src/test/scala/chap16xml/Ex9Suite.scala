package chap16xml

import org.scalatest.{FunSuite, Matchers}

class Ex9Suite extends FunSuite with Matchers {

  import Ex9.altTODOEnrich

  test("transformation of doc with no empty alt atts leave it unaffected") {

    val html = <html><body><img alt="aa" src="a"/><table><img src="b" alt="dc">dog and cat</img></table></body></html>

    altTODOEnrich(html) should be (html)
  }

  test("empty <img/> tag gets transformed to <img alt='TODO'/>") {

    altTODOEnrich(<html><img/></html>) should be (<html><img alt="TODO"/></html>)
  }

  test("<img src='aaa'/> tag gets transformed to <img src='aaa' alt='TODO'/>") {

    altTODOEnrich(<html><img src="aaa"/></html>) should be (<html><img src="aaa" alt="TODO"/></html>)
  }

  test("<img src='aaa'>content</img> tag with content gets transformed to <img src='aaa' alt='TODO'>content</img>") {

    altTODOEnrich(<html><img src="aaa">content</img></html>) should be (<html><img src="aaa" alt='TODO'>content</img></html>)
  }

  test("all img tags with empty alt att gets transformed") {
    val html = <html><body><img src=""/><table><img src="b">dog and cat</img></table><img alt="hum">boom</img></body></html>

    altTODOEnrich(html) should be (
      <html><body><img alt="TODO" src=""/><table><img alt="TODO" src="b">dog and cat</img></table><img alt="hum">boom</img></body></html>
    )
  }
}
