package chap9filesandregex

import org.scalatest.{FunSuite, Matchers}

class Ex8Suite extends FunSuite with Matchers {

  import Ex8.srcOfHtmlImg

  test("finds all src att vals in img tags in html") {

    val html =
      """asdasdasdas<img a="asdasd" src="http://asdasdas/source1"/>
        |<img src="source2" >
        |<img src="a/source3" dssad as das das >sad sa
        |asd a
        |
      """.stripMargin

    srcOfHtmlImg(html).toSeq should be (Seq("http://asdasdas/source1", "source2", "a/source3"))
  }
}
