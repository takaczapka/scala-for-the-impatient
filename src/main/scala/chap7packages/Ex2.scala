package chap7packages {

/**
 * 2. Write a puzzler that baffles your Scala friends, using a package com that isn’t at the top level.
 */

object Ex2 {
  com.oracle.boom.Do.reload() // confusing? maybe. but legal.
}

package com.oracle.boom {

object Do {

  def reload(): Unit = {}
}

}


}