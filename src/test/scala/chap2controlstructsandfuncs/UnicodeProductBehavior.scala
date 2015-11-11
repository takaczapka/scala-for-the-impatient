package chap2controlstructsandfuncs

import helpers.Generators._
import org.scalatest.FunSuite

trait UnicodeProductBehavior {
  this: FunSuite =>

  def product(s: String): Long

  test("Product of Unicode characters in empty string is 0") {
    assert(product(null) === 0)
    assert(product("") === 0)
  }

  test("Product of Unicode characters in one char string is equal to unicode value of that char") {
    val char = anyChar
    assert(product(char.toString) === char.toLong)
  }

  test("Product of Unicode characters in \"Hello\" is 9415087488L") {
    assert(product("Hello") === 9415087488L)
  }
}
