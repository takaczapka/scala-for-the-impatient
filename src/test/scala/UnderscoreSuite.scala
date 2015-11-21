import org.scalatest.{Matchers, FunSuite}

class UnderscoreSuite extends FunSuite with Matchers {


  test("wildcard imports") {
    import math._

    sqrt(1.41)
  }

  test("hiding imports") {
    import math.{sqrt => _, _}

    max(2, 2)
    // sqrt(1.2) - invalid
  }

  test("wildcard pattern matching") {
    val o = Some(1)

    o match {
      case Some(_) => "some"
      case _ => "everything else"
    }
  }

  test("ignored parameters") {
    List(1, 2, 3) foreach { _ => println("Hi") }
  }

  test("assignment operator") {
    class F {
      var _foo: Int = _

      def foo_=(x: Int) {
        _foo = x
      }

      def foo: Int = _foo
    }

    val f = new F()
    f.foo = 2

    f.foo should be(2)
  }

  test("placeholder syntax") {
    List(1, 2, 3) map (_ + 2) should be(List(3, 4, 5))
    List(1, 2, 3) reduceLeft (_ + _) should be(6)
  }

  test("partially applied function") {
    List(1, 2, 3) foreach println _ // but undescore is not mandatory here anymore as in below examples (had it changed in Scala?)
    List(1, 2, 3) foreach println

    def f: Int = 5
    val f2: () => Int = f _

    def g(): Int = 5
    val g2: () => Int = g

    def h(x: Int) = x
    val h2: (Int) => Int = h

    def i(x: Int)(y: Int) = x + y
    val i1: (Int) => (Int) => Int = i
    val i2: (Int) => Int = i(1)
  }

  test("higher kinded type parameters") {
    case class A[K[_], T](a: K[T])

    A(List(1.23))
  }

  test("existential types, or Java-like wildcards") {
    def foo(l: List[Option[_]]) = l.length

    foo(List(Some(1), Some(2), None)) should be(3)
  }

  test("tupel access") {
    val t = 1 -> 2
    t._1 should be (1)
    t._2 should be (2)
  }
}
