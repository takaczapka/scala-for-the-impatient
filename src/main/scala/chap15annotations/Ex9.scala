package chap15annotations

/**
  * 9. The Range.foreach method is annotated as @specialized( Unit). Why? Look at the bytecode by running
  *
  * javap -classpath /path/to/scala/lib/ scala-library.jar scala.collection.immutable.Range
  *
  * and consider the @specialized annotations on Function1. Click on the Function1.scala link in Scaladoc to see them.
  */
object Ex9 {

  // I think that Range.foreach is annotated with @specialized(Unit) as that's the most common case to use foreach call,
  // and foreach by definition applies a function to the contents of the sequence, which usually have side-effects.

  // Function1 alread has specialized annotation in its definition.
  // trait Function1[@specialized(scala.Int, scala.Long, scala.Float, scala.Double) -T1, @specialized(scala.Unit,
  // scala.Boolean, scala.Int, scala.Float, scala.Long, scala.Double) +R] extends AnyRef { self =>
}
