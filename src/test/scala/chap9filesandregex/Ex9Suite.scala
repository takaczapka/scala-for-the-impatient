package chap9filesandregex

import java.io.File

import helpers.Helpers
import org.scalatest.{FunSuite, Matchers}

import scala.annotation.tailrec

class Ex9Suite extends FunSuite with Matchers {

  import Ex9._

  test("finds all src att vals in img tags in html") {

    val dir = new File(getClass.getResource("/chap9filesandregex").getPath)
    howManyClassFiles(dir) should be > 25
  }
  
  ignore("tailrec vs folding") {

    def howManyFiles(dir: File): Int = {

      val c = dir.listFiles().count { f => f.isFile }

      dir.listFiles().filter(_.isDirectory).foldLeft(c)((c, dir) => c + howManyFiles(dir))
    }

    @tailrec
    def howManyFiles2(dir: File, toProcess: List[File] = Nil, acc: Int = 0): Int = {

      val c = dir.listFiles().count { f => f.isFile }
      val dirs = dir.listFiles().filter(_.isDirectory).toList ++ toProcess

      if (dirs.isEmpty) acc + c
      else howManyFiles2(dirs.head, dirs.tail, acc + c)
    }


    val dir2 = new File("/Users/takaczapka")
    Helpers.measureIt {
      println("foldL: " + howManyFiles(dir2))
    }
    Helpers.measureIt {
      println("tailrec: " + howManyFiles2(dir2))
    }
  }
}

