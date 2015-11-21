package chap16xml

import scala.xml.{Node, Elem}

/**
  * 1. What is <fred/>(0)? <fred/>(0)(0)? Why?
  */
object Ex1 extends App {

  val e: Elem = <fred/>
  val n1: Node = e(0)
  val n2: Node = e(0)(0)

  // <fred/>(0) and <fred/>(0)(0) are equal:
  // * <fred/> is an Elem, which is a subclass of Node, which is a subclass of NodeSeq
  // * apply(i: Int) is a method inherited from NodeSeq
  // * <fred/>(0) returns a first node from one-element sequence
  // * <fred/>(0)(0) gets a first Node and replies apply(0) on itself which returns it again
}
