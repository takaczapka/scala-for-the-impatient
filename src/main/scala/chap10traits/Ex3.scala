package chap10traits

/**
 * 3. Look at the BitSet class, and make a diagram of all its superclasses and traits.
 * Ignore the type parameters (everything inside the [...]).
 * Then give the linearization of the traits.
 */
object Ex3 {


  // LINEARIZATION
  // BitSet,
  // BitSetLike[BitSet],
  // SortedSet[Int], SortedSetLike[Int, BitSet], Sorted[Int, BitSet], Set[Int], SetLike[Int, BitSet],
  // Subtractable[Int, BitSet],
  // GenSet[Int], GenericSetTemplate[Int, Set], GenSetLike[Int, BitSet],
  // Iterable[Int], IterableLike[Int, BitSet],
  //  Equals,
  // GenIterable[Int], GenIterableLike[Int, BitSet],
  // Traversable[Int], GenTraversable[Int], GenericTraversableTemplate[Int, Set], TraversableLike[Int, BitSet], GenTraversableLike[Int, BitSet],
  // Parallelizable[Int, ParSet[Int]],
  // TraversableOnce[Int],
  // GenTraversableOnce[Int],
  // FilterMonadic[Int, BitSet],
  // HasNewBuilder[Int, BitSet], (Int) ⇒ Boolean,
  // AnyRef,
  // Any
}
