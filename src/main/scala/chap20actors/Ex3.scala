package chap20actors

import java.io.File
import java.util.concurrent.TimeUnit

import akka.util.Timeout
import chap20actors.mapreduce.Functions.{ComputeFunction, MapFunction, ReduceFunction}
import chap20actors.mapreduce.MapActor.Work
import chap20actors.mapreduce.MapReduce

import scala.io.Source
import scala.util.Try
import scala.util.matching.Regex

/**
  * 3. Write a program that counts how many words match a given regular expression in all files of all subdirectories
  * of a given directory. Have one actor per file, one actor that traverses the subdirectories, and one actor
  * to accumulate the results.
  */
object Ex3 {

  def countRegexMatches(dir: String, regex: Regex): Try[Int] = {
    val mapFunction = new MapFunction[String, File] {
      override def apply(dir: String) = Files.files(new File(dir))
    }
    val computeFunction = new ComputeFunction[File, Int] {
      override def apply(t: File): Int = regex.findAllMatchIn(Source.fromFile(t).mkString).length
    }
    val reduceFunction = new ReduceFunction[Int]() {
      override def apply(a: Int, b: Int): Int = a + b
    }

    val work = Work[String, File, Int](dir, mapFunction, reduceFunction, computeFunction)

    new MapReduce().run(work)(Timeout(20, TimeUnit.SECONDS))
  }
}
