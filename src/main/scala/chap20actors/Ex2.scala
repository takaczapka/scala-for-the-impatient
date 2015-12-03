package chap20actors

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.util.concurrent.TimeUnit
import javax.imageio.ImageIO

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * 2. Write a program that reads in a large image into a BufferedImage, using javax.imageio.IOImage.read.
  * Use multiple actors, each of which inverts the colors in a strip of the image. When all strips have been
  * inverted, write the result.
  */
object Ex2 extends App {

  case class ImageInverted(file: File)

  object InvertImageActor {

    case class InvertImage(file: File)

    case class StripInverted()

    def imgToFile(imgFile: File, img: BufferedImage): File = {
      val outputFile = new File(imgFile.getParentFile, imgFile.getName.substring(0, imgFile.getName.lastIndexOf('.')) + "-inv.png")
      ImageIO.write(img, "png", outputFile)
      outputFile
    }
  }

  class InvertImageActor extends Actor {

    import InvertImageActor._

    var workerActors: Int = 5

    var imgFile: File = _
    var img: BufferedImage = _
    var resultsReceived: Int = _
    var replyTo: ActorRef = _

    def initState(imageFile: File): Unit = {
      img = ImageIO.read(imageFile)
      imgFile = imageFile
      replyTo = sender()
      resultsReceived = 0
    }

    override def receive: Receive = {
      case InvertImage(file) =>

        initState(file)

        Ex1Helper.ranges(img.getHeight(), workerActors).foreach { case (y0, y1) =>
          context.actorOf(Props[StripInverterActor]) ! StripInverterActor.InvertStrip(img, y0, y1)
        }
        context.become(computing)
    }


    def computing: Receive = {
      case StripInverted =>
        resultsReceived += 1
        if (resultsReceived == workerActors) {
          val outputFile = imgToFile(imgFile, img)
          replyTo ! ImageInverted(outputFile)
          context.become(receive)
        }
    }
  }

  object StripInverterActor {

    case class InvertStrip(image: BufferedImage, y0: Int, y1: Int)

    def invertStrip(img: BufferedImage, _from: Int, _to: Int): Unit = {
      for (x <- 0 until img.getWidth; y <- _from to _to) {
        val col = new Color(img.getRGB(x, y), true)
        val newCol = new Color(255 - col.getRed, 255 - col.getGreen, 255 - col.getBlue)
        img.setRGB(x, y, newCol.getRGB)
      }

    }
  }

  class StripInverterActor extends Actor {

    import StripInverterActor._

    override def receive: Receive = {
      case InvertStrip(img, y0, y1) =>
        invertStrip(img, y0, y1)
        sender() ! InvertImageActor.StripInverted
    }
  }

  override def main(args: Array[String]): Unit = {
    val imgFile = new File(getClass.getResource("/chap20actors/tenerife.jpg").getFile)

    val system = ActorSystem("img-inverter")

    try {
      val actor = system.actorOf(Props[InvertImageActor])

      implicit val timeout: Timeout = Timeout(10, TimeUnit.SECONDS)
      val result = Await.result(actor ? InvertImageActor.InvertImage(imgFile), 5 seconds)
      val ImageInverted(invertedFile) = result
      println("Inverted file location " + invertedFile.getAbsolutePath)
    } finally {
      system.terminate()
    }
  }
}
