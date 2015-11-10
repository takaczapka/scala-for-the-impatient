package chap8inheritance

/**
 * 10. The file scala/collection/immutable/ Stack.scala contains the definition
 *
 * class Stack[A] protected (protected val elems: List[A])
 *
 * Explain the meanings of the protected keywords. (Hint: Review the discussion of private constructors in Chapter 5.)
 */
object Ex10 {

  // A protected member is only accessible from subclasses of the class in which the member is defined.
  // In the same way, protected constructor can only be called by subclasses, but not the client code.
  // Non-parametrized protected keyword make fields, methods or constructors only visible from subclasses, while
  // in Java it grants also a package level access.

  // Another form is parametrized protected[foo], where foo can be a class, package or object.
  // If the protected is parametrized then only classes, objects or packages that fall into the parameter category
  // can access the marked field, method or constructor.
}
