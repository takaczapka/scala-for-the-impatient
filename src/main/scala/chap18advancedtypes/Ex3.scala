package chap18advancedtypes

/**
  * 3. Complete the fluent interface in Section 18.1, “Singleton Types,” on page 246 so that one can call
  *
  * book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
  */
object Ex3 {

  object Title

  object Author

  class Document {
    private var useNextArgAs: Any = null
    var title: String = _
    var author: String = _

    def set(obj: Title.type): this.type = {
      useNextArgAs = obj
      this
    }

    def set(obj: Author.type): this.type = {
      useNextArgAs = obj
      this
    }

    def to(arg: String) = {
      useNextArgAs match {
        case Title => title = arg
        case Author => author = arg
      }
      this
    }
  }

}
