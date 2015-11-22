package chap19parsing

import java.text.SimpleDateFormat
import java.util.{Date, Calendar}

import org.scalatest.{FunSuite, Matchers}

class Ex4Suite extends FunSuite with Matchers {

  import Ex4.ISO8601DateParser

  val parser = new ISO8601DateParser()

  def parse(s: String) = {
    val date = parser.parseAll(parser.expr, s).get
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    sdf.format(date)
  }

  test("just dates") {

    parse("2015-11-02") should be ("2015-11-02 00:00:00")
    parse("20151102") should be ("2015-11-02 00:00:00")
    parse("201511") should be ("2015-11-01 00:00:00")
    parse("2015-11") should be ("2015-11-01 00:00:00")
    parse("2015") should be ("2015-01-01 00:00:00")
  }

  test("date and time") {

    parse("2015-11-02 23") should be ("2015-11-02 23:00:00")
    parse("2015-11-02 23:34") should be ("2015-11-02 23:34:00")
    parse("2015-11-02 23:34:12") should be ("2015-11-02 23:34:12")
    parse("2015-11-02T23:34:20") should be ("2015-11-02 23:34:20")
  }
}
