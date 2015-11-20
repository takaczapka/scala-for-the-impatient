package chap14caseclasses

/**
  * 7. Extend the tree in the preceding exercise so that each node can have an arbitrary number of children,
  * and reimplement the leafSum function. The tree in exercise 5 should be expressible as
  *
  * Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
  */
object Ex7 {

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(trees: BinaryTree*) extends BinaryTree

  def sum(tree: BinaryTree): Int = tree match {
    case Leaf(n) => n
    case Node(trees@_*) => trees.map(sum).sum
  }
}
