package chap20actors

import java.io.FileFilter

object Files {

  import java.io.File

  def subdirs(dir: File): Iterator[File] = {
    val children = dir.listFiles.filter(_.isDirectory)
    children.toIterator ++ children.toIterator.flatMap(subdirs)
  }

  object AllPassFilter extends FileFilter {
    override def accept(pathname: File): Boolean = true
  }

  class ExtensionFileFilter(_ext: String) extends FileFilter {
    val ext = "." + _ext

    override def accept(pathname: File): Boolean = pathname.getName.endsWith(ext)
  }

  def files(dir: File, filter: FileFilter = AllPassFilter): Iterator[File] =
    (dir.listFiles.toIterator ++ subdirs(dir).flatMap(_.listFiles)).
      filter { f => f.isFile && f.canRead && filter.accept(f) }
}
