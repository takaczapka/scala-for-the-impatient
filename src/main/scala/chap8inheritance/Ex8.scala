package chap8inheritance

/**
 * 8. Compile the Person and SecretAgent classes in Section 8.6, “Overriding Fields,” on page 89 and analyze the
 * class files with javap. How many name fields are there? How many name getter methods are there? What do they get?
 * (Hint: Use the -c and -private options.)
 */
object Ex8 {

  class Person(val name: String) {
    override def toString = getClass.getName + s"[name=$name]"
  }

  class SecretAgent(codeName: String) extends Person(codeName) {
    override val name = "secret"

    override def toString = "secret"
  }

  // ANSWER
  // Not sure where is the catch here, but one thing worth mentioning is that "val name" of class Person
  // is a private final class field for both Person and SecretAgent. However "codeName" in SecretAgent is forgotten
  // and not translated to any class member as it's used only in instance construction process.
}
