package chap5classes

import scala.beans.BeanProperty

/**
 * 5. Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long).
 * What methods are generated? (Use javap to check.) Can you call the JavaBeans getters and setters in
 * Scala. Should you?
 */
object Ex5 {

  class Student(@BeanProperty var name: String, @BeanProperty var id: Long)

  // ANSWER
  // Scala- and Java-style accessor methods are generated. All can and should be accessed form Scala code.
}
