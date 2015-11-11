package chap9filesandregex

import java.io.{PrintWriter, File}

object FileHelpers {
  def createTempFile(content: String = ""): File = {
    val f = File.createTempFile("chap9", "tmp")
    val pw = new PrintWriter(f)
    pw.print(content)
    pw.close()
    f
  }
}
