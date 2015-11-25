package chap21implicits

/**
  * 8. Use the implicitly command in the REPL to summon the implicit objects described in Section 21.5,
  * “Implicit Parameters,” on page 309 and and Section 21.6, “Implicit Conversions with Implicit Parameters,”
  * on page 310. What objects do you get?
  */
object Ex8 {

  // ANSWER

  // I get a conversion functions, f.e.:
  // scala> val a = implicitly[Int => Ordered[Int]]
  // a: Int => Ordered[Int] = <function1>
  //
  // scala> a(1)
  // res18: Ordered[Int] = 1
  //
  // However if it's a class conversion, ie. Int to RichInt, implicitly doesn't bring anything useful.
}


/*

Scala console interaction with _implicitly_

// implicit objects

scala> implicit object IntOrdering extends  Ordering[Int] {
     |   override def compare(x: Int, y: Int): Int = -1
     | }
defined object IntOrdering

scala> val f = implicitly[Ordering[Int]]
f: Ordering[Int] = IntOrdering$@38bc8ab5

scala> f.compare(1, 2)
res1: Int = -1

// implicit values
scala> implicit val a: Int = -1
a: Int = -1

scala> implicitly[Int]
res23: Int = -1


// implicit functions
scala> implicit def add(i: Int, j: Int) = i + j
add: (i: Int, j: Int)Int

scala> val f = implicitly[(Int, Int) => Int]
scala> f(2, 3)
res20: Int = 5

// implicit conversions (let's use a predefined one)

scala> val f = implicitly[String => Ordered[String]]
f: String => Ordered[String] = <function1>

scala> val s = f("a")
s: Ordered[String] = a

scala> s.compare("b")
res11: Int = -1

*/