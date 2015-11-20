package chap14caseclasses

/**
  * 6. A better way of modeling such trees is with case classes. Let’s start with binary trees.
  *
  * sealed abstract class BinaryTree
  * case class Leaf( value: Int) extends BinaryTree
  * case class Node( left: BinaryTree, right: BinaryTree) extends BinaryTree
  *
  * Write a function to compute the sum of all elements in the leaves.
  */
object Ex6 {

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

  def sum(tree: BinaryTree, acc: Int = 0): Int = tree match {
    case Leaf(n) => n
    case Node(left, right) => sum(left) + sum(right)
  }
}
