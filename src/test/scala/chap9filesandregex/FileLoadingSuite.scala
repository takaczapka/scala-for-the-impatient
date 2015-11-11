package chap9filesandregex

import java.io.File

import org.scalatest.{Matchers, FunSuite}

// Some facts about accessing the files
class FileLoadingSuite extends FunSuite with Matchers {

  // that's where the execution of the code happens
  private val userDir: String = System.getProperty("user.dir")
  private val packagePath = "chap9filesandregex"
  private val thisClassFile = "FileLoadingSuite.class"

  test("using plain File requires absolute paths or paths relative to execution directory") {

    new File("/").getAbsolutePath should be("/")
    new File(userDir).getAbsolutePath should be(userDir)

    new File("").getAbsolutePath should be(userDir)
    new File(".").getAbsolutePath should be(userDir + "/.")
    new File(packagePath).getAbsolutePath should be(userDir + "/" + packagePath)
    new File(packagePath + "/" + thisClassFile).getAbsolutePath should be(userDir + "/" + packagePath + "/" + thisClassFile)
  }

  test("using getResource puts an absolute root in a class path or relative root in a current package") {

    // all classpath items can be accessed here
    // * main classes
    new File(getClass.getResource("/" + packagePath + "/Ex1.class").getFile) should be('exists)
    // * test classes
    new File(getClass.getResource("/" + packagePath + "/FileLoadingSuite.class").getFile) should be('exists)
    // * resources
    new File(getClass.getResource("/some-resource.txt").getFile) should be('exists)

    // but this points to the root of the folder where classes are, in this case test-classes
    // folder under project-path/target/scala2.11/
    new File(getClass.getResource("/").getFile).getAbsolutePath should endWith("/test-classes")

    // but this is folder spetific path (or package specific)
    new File(getClass.getResource(".").getFile).getAbsolutePath should endWith("/" + packagePath)
    new File(getClass.getResource("").getFile).getAbsolutePath should endWith("/" + packagePath)
    // so you can access from here everything which is in this package (main classes, test classes and resources
    new File(getClass.getResource("./Ex1.class").getFile) should be('exists)
    // or without ./ prefix
    new File(getClass.getResource("Ex1.class").getFile) should be('exists)
    new File(getClass.getResource(thisClassFile).getFile) should be('exists)

    /*
     * Note: Referring to the resource prefixed with a . will cause the ClassLoader to also look for files outside
     * of the JAR, while not prefixing the resource path with a period will direct the ClassLoader to look only
     * inside the JAR file.
     */
  }
}
