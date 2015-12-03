package chap20actors

import java.util.concurrent.TimeUnit

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout
import chap20actors.Ex1Helper.ranges
import helpers.Helpers.timeIt

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.Random

/**
  * 1.Write a program that generates an array of n random numbers (where n is a large value, such as 1,000,000),
  * and then computes the average of those numbers by distributing the work over multiple actors, each of which
  * computes the sum of a subrange of the values, sending the result to an actor that combines the results.If you
  * run your program on a dual - core or quad - core processor, what is the speedup over a single - threaded solution?
  */
// ANSWER
// Actor based solution doesn't bring a speedup here. I think that there is an overhead in creating Actor's threads
// and splitting the work, so it doesn't bring any obvious benefits over regular seq.sum operations. Using
// seq.par.sum doesn't bring a massive jump in performance neither. Actually, by using Array over Vector or List,
// makes regular sum operation even faster.
object Ex1 extends App {

  case class ComputeAvg(nums: Seq[Int], workerActors: Int)

  case class AvgResult(result: Double)

  case class ComputeSliceSum(nums: Seq[Int], from: Int, to: Int)

  case class SliceSumResult(result: Int)

  class ComputeAvgActor extends Actor {

    var workerActors: Int = _
    var resultsAggregator: ArrayBuffer[Double] = ArrayBuffer()
    var replyTo: ActorRef = _
    var numsLength: Int = _

    def computing: Receive = {
      case SliceSumResult(r) =>
        resultsAggregator += r.toDouble
        if (resultsAggregator.length == workerActors) {
          replyTo ! AvgResult(resultsAggregator.sum / numsLength)
          context.become(receive)
        }
    }

    override def receive: Receive = {
      case ComputeAvg(nums, _workerActors) =>
        workerActors = _workerActors
        numsLength = nums.length
        replyTo = sender()
        resultsAggregator.clear()

        ranges(nums.length, workerActors).foreach {
          case (from, to) =>
            context.actorOf(Props[SliceSumActor]) ! ComputeSliceSum(nums, from, to + 1)
        }

        context.become(computing)
    }
  }

  class SliceSumActor extends Actor {
    override def receive: Actor.Receive = {
      case ComputeSliceSum(nums, from, to) =>
        sender ! SliceSumResult(nums.slice(from, to).sum)
    }
  }

  override def main(args: Array[String]) {

    val nums = (for (i <- 0 to 10000000) yield Random.nextInt()).toArray
    val workerActors = 4 // number of cores
    println("Collection of [" + (nums.length - 1) + "] elements.")
    println(workerActors + " sum worker actors.")

    val system = ActorSystem("sum-avg")

    try {
      val avgActor = system.actorOf(Props[ComputeAvgActor])

      timeIt {
        implicit val timeout: Timeout = Timeout(10, TimeUnit.SECONDS)
        val result = Await.result(avgActor ? ComputeAvg(nums, workerActors), 5 seconds)
        val AvgResult(resultValue) = result
        println("Actor's result: " + resultValue)
      }

      timeIt {
        println("Regular coll result: " + nums.sum.toDouble / nums.length)
      }

      val parNums = nums.par
      timeIt {
        println("Parallel coll result: " + parNums.sum.toDouble / nums.length)
      }

    } finally {
      system.terminate()
    }
  }
}

object Ex1Helper {
  def ranges(until: Int, chunks: Int): Seq[(Int, Int)] = {
    assert(chunks > 0)
    assert(until >= chunks)

    val step = (until - 1) / chunks

    def ranges(curr: Int, acc: Seq[(Int, Int)]): Seq[(Int, Int)] = {
      if (curr < until) {
        val next = curr + step
        if (next >= until) acc :+ (curr -> (until - 1))
        else ranges(next + 1, acc :+ (curr -> next))
      } else acc
    }

    ranges(0, Seq.empty)
  }
}