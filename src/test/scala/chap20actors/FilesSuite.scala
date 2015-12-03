package chap20actors

import java.io.File

import org.scalatest.{Matchers, FunSuite}

class FilesSuite extends FunSuite with Matchers {

  import Files._

  test("find all subdirs") {
    val root = new File(getClass.getResource("/chap20actors/poems").getFile)

    subdirs(root).map(_.getName).toSet should be(Set("subdir1", "subdir2", "subsubdir1"))
  }

  test("find all subdirs removes an empty seq if there is no subdirs") {
    val root = new File(getClass.getResource("/chap20actors/poems/subdir2").getFile)

    subdirs(root).toSeq should be(Seq.empty)
  }

  test("creates a file iterator with all relevant contents") {
    val root = new File(getClass.getResource("/chap20actors/poems").getFile)

    files(root).map(_.getName).toSet should be(Set("the-angel.txt", "poison-tree.txt", "a-cradle-song.txt", "a-divine-image.txt", "auguries-of-innocence.txt", "love-s-secret.txt", "the-tyger.txt"))
  }

  test("is able to filter only matching files") {
    val root = new File(getClass.getResource("/chap20actors/poems").getFile)

    files(root, new ExtensionFileFilter("pdf")).toSeq should be(Seq.empty)
    files(root, new ExtensionFileFilter("txt")).toSeq.size should be(7)
  }

}