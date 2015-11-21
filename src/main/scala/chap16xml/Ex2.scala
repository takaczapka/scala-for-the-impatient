package chap16xml

/**
  * 2. What is the result of
  *
  * <ul>
  * <li>Opening bracket: [</li>
  * <li>Closing bracket: ]</li>
  * <li>Opening brace: {</li>
  * <li>Closing brace: }</li>
  * </ul>
  *
  * How do you fix it?
  */
object Ex2 {
  <ul>
    <li>Opening bracket: [</li>
    <li>Closing bracket: ]</li>
    <li>Opening brace: {{</li>
    <li>Closing brace: }}</li>
  </ul>

  // { and } are special characters reserved for code generation snippets in Scala. Use {{ or }} to obrain just { or }
  // in XML.
}
