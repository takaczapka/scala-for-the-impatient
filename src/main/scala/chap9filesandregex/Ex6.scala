package chap9filesandregex

/**
 * 6. Make a regular expression searching for quoted strings "like this, maybe with \" or \\" in
 * a Java or C++ program. Write a Scala program that prints out all such strings in a source file.
 */
object Ex6 {

  val pattern = """like this, maybe with [\|\\]""".r

}
