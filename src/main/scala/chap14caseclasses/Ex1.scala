package chap14caseclasses

/**
 * 1. Your Java Development Kit distribution has the source code for much of the JDK in the src.zip file.
 * Unzip and search for case labels (regular expression case [^:] +:). Then look for comments starting with
 * // and containing alls? thr to catch comments such as // Falls through or // just fall thru. Assuming the
 * JDK programmers follow the Java code convention, which requires such a comment, what percentage of cases falls
 * through?
 */
object Ex1 {
  // Based on src.zip of JAVA8

  // > grep -R "case [^:]*:" * | wc -l
  //  10120
  // > grep -R "//.*all.*thr" * | wc -l
  //  230

  // Only 2.3% of cases falls through
}
