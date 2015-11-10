package chap7packages

/**
 * 8. What is the effect of
 * import java._
 * import javax._
 *
 * Is this a good idea?
 */
object Ex8 {
  // It means that all the packages from those prefixes are becoming available for shorter import, fe.
  // no need to write "import java.xml", but "import xml".
  //
  // Not necessary great idea as it makes harder to maintain a clarity of imports and they might clash with
  // local packages. Readability and reasoning suffers here. It's a good practice to use full qualified package
  // imports.
}
