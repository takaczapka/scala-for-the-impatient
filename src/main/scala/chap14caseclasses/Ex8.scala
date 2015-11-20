package chap14caseclasses

/**
  * 8. Extend the tree in the preceding exercise so that each non-leaf node stores an operator in addition to
  * the child nodes. Then write a function eval that computes the value. For example, the tree
  *
  * +
  * /| \
  * * 2  -
  * /  \   |
  * 3   8   5
  *
  * has value (3 × 8) + 2 + (– 5) = 21.
  */
object Ex8 {

  sealed abstract class BinaryTree

  case class Leaf(value: Int) extends BinaryTree

  case class Node(operator: Char, trees: BinaryTree*) extends BinaryTree

  def sum(tree: BinaryTree): Int = tree match {
    case Leaf(n) => n
    case Node(operator, trees@_*) => {
      val nums = trees.map(sum)
      operator match {
        case '+' => nums.sum
        case '-' => nums.reduceLeft(_ - _)
        case '*' => nums.product
      }
    }
  }
}
