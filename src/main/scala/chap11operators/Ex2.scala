package chap11operators

/**
 * 2. The BigInt class has a pow method, not an operator. Why didn’t the Scala library designers choose
 * ** (as in Fortran) or ^ (as in Pascal) for a power operator?
 */
object Ex2 {

  // ANSWER
  // ^ operator has a lower associativity than + which would mean that expression 2 + 3 ^ 4 would be evaluated (2 + 3) ^ 4
  // which is incorrect regarding arithmetic rules

  // ** operator has the same associativity as *, hence again this wouldn't follow the arithmetic operator associativity
  // rules
}
