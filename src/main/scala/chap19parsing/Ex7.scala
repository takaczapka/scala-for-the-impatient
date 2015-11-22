package chap19parsing

/**
  * 7. Suppose in Section 19.6, “Avoiding Left Recursion,” on page 276, we first parse an expr into a list of ~
  * with operations and values:
  *
  * def expr: Parser[Int] = term ~ rep((" +" | "-") ~ term) ^^ {...}
  *
  * To evaluate the result, we need to compute (( t0 ± t1) ± t2) ± . . . Implement this computation as a fold
  * (see Chapter 13).
  */
object Ex7 {
  // See Ex2 or Ex6 solutions
}
