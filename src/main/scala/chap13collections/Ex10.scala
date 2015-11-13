package chap13collections

/**
 * 10. Harry Hacker reads a file into a string and wants to use a parallel collection to update the letter frequencies
 * concurrently on portions
 *
 * val frequencies = new scala.collection.mutable.HashMap[ Char, Int]
 * for (c <- str.par) frequencies(c) = frequencies.getOrElse( c, 0) + 1
 *
 * Why is this a terrible idea? How can he really parallelize the computation? (Hint: Use aggregate.)
 */
object Ex10 {

  // .par means in parallel by many threads and since "frequencies(c) = frequencies.getOrElse( c, 0) + 1" are two
  // operations and not a single atomic one, then we run into the problems here.

  // aggregate() would work in this way as it traverses the elements in different partitions
  // sequentially, sequentially updating the result, and then combines results from different partitions.
  // see Ex10Suite for an example of aggregate
}
