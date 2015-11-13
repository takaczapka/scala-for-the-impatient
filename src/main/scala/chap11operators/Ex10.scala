package chap11operators

/**
 * 10. Define an unapplySeq operation for the RichFile class that extracts all path segments. For example,
 * for the file /home/cay/ readme.txt, you should produce a sequence of three segments: home, cay, and readme.txt.
 */
object Ex10 {

  object RichFile {
    def unapplySeq(path: String): Option[Seq[String]] = {
      Some(path.split("/"))
    }
  }

}
