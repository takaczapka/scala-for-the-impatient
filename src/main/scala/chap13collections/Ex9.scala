package chap13collections

/**
 * 9. Harry Hacker writes a program that accepts a sequence of file names on the command line. For each, he starts
 * a new thread that reads the file and updates the letter frequency map, declared as
 *
 * val frequencies = new scala.collection.mutable.HashMap[Char, Int] with scala.collection.mutable.SynchronizedMap[Char, Int]
 *
 * When reading a letter c, he calls
 *
 * frequencies(c) = frequencies.getOrElse( c, 0) + 1
 *
 * Why won’t this work? Will it work if he used instead
 *
 * import scala.collection.JavaConversions.asScalaConcurrentMap
 * val frequencies: scala.collection.mutable.ConcurrentMap[Char, Int] = new java.util.concurrent.ConcurrentHashMap[Char, Int]
 */
object Ex9 {

  // It will not work in neither case. The problem is a following line:
  // frequencies('c') = frequencies.getOrElse('c', 0) + 1
  // which is not an atomic operation - there are two operations get and update and there's nothing protecting
  // them to be executed by many threads at once.
}
