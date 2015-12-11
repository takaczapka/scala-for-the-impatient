package chap20actors

import java.io.File
import java.util.concurrent.TimeUnit

import akka.util.Timeout
import chap20actors.mapreduce.Functions.{ReduceFunction, ComputeFunction, MapFunction}
import chap20actors.mapreduce.MapActor.Work
import chap20actors.mapreduce.MapReduce

import scala.io.Source
import scala.util.Try
import scala.util.matching.Regex

/**
  * 7. Add a supervisor to the program of exercise 3 that monitors the file reading actors and logs any that exit
  * with an IOException. Try triggering the exception by removing files that have been scheduled for processing.
  */
object Ex7 {

  def findAllMatchesWithFilesWithErrors(dir: String, regex: Regex): Try[Map[String, Set[String]]] = {

    // added two non-existing file
    val mapFunction = new MapFunction[String, File] {
      override def apply(dir: String) = Files.files(new File(dir)) ++
        Seq(new File("file-not-exist-1")).toIterator
    }

    val computeFunction = new ComputeFunction[File, Map[String, Set[String]]] {
      override def apply(t: File): Map[String, Set[String]] = {
        val p = t.getName
        regex.findAllMatchIn(Source.fromFile(t).mkString).map(_.matched).toSet[String].map(w => w -> Set(p)).toMap
      }
    }

    val reduceFunction = new ReduceFunction[Map[String, Set[String]]]() {
      override def apply(a: Map[String, Set[String]], b: Map[String, Set[String]]): Map[String, Set[String]] = {
        a ++ b.map { case (k, v) => k -> (v ++ a.getOrElse(k, Set.empty)) }
      }
    }

    val work = Work[String, File, Map[String, Set[String]]](dir, mapFunction, reduceFunction, computeFunction)

    new MapReduce().run(work)(Timeout(20, TimeUnit.SECONDS))
  }

}
