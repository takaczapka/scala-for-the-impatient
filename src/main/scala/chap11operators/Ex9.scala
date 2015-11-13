package chap11operators

/**
 * 9. Define an unapply operation for the RichFile class that extracts the file path, name, and extension.
 * For example, the file /home/cay/readme.txt  has path /home/cay, name readme, and extension txt.
 */
object Ex9 {
  // NOTE
  // it looks like unapply and unappyseq when declared together are negating each other.
  // If both unapply and unapplySeq are defined only unapply is used.

  object RichFile {
    val pattern = """(.*)/(\w+)\.(\w+)""".r

    def unapply(path: String): Option[(String, String, String)] = {
      path match {
        case pattern(prepath, filename, ext) => Some((prepath, filename, ext))
        case _ => None
      }
    }
  }
}
