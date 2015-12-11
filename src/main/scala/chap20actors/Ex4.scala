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
  * 4. Modify the program of the preceding exercise to display all matching words.
  */
object Ex4 {

  def findAllMatches(dir: String, regex: Regex): Try[Seq[String]] = {
    val mapFunction = new MapFunction[String, File] {
      override def apply(dir: String) = Files.files(new File(dir))
    }
    val computeFunction = new ComputeFunction[File, Seq[String]] {
      override def apply(t: File): Seq[String] =
        regex.findAllMatchIn(Source.fromFile(t).mkString).map(_.matched).toSeq
    }
    val reduceFunction = new ReduceFunction[Seq[String]]() {
      override def apply(a: Seq[String], b: Seq[String]): Seq[String] = a ++ b
    }

    val work = Work[String, File, Seq[String]](dir, mapFunction, reduceFunction, computeFunction)

    new MapReduce().run(work)(Timeout(20, TimeUnit.SECONDS))
  }
}
