package chap2controlstructsandfuncs

/**
 * 4. Write a Scala equivalent for the Java loop
 *      for (int i = 10; i > = 0; i--) System.out.println( i);
 */
object Ex4 extends App {

  for (i <- 10 to 0 by -1) println(i)
  for (i <- 10 until -1 by -1) println(i)
}
