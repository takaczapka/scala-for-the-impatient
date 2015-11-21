package chap15annotations

/**
  * 2. Make an example class that shows every possible position of an annotation. Use @deprecated as your sample
  * annotation.
  */
object Ex2 {

  @deprecated
  class Ex2[@deprecated T] @deprecated()(@deprecated val i: Int) {

    @deprecated
    val v: Int = 1

    // expression annotation
    val a = (1 + 2: @deprecated)

    @deprecated
    def fun(@deprecated a: Int): Int = {
      1
    }
  }

}
