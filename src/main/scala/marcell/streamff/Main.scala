package marcell.streamff

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import io.circe.fs2._
import io.circe._
import io.circe.parser._
import io.circe.generic.semiauto._
import io.circe.syntax._
import io.circe.Decoder

import scala.io.Source

object Main extends IOApp {
  def run(args: List[String]) = {

    implicit val whDecoder = deriveDecoder[WebhookSetting]
    implicit val whEncoder = deriveEncoder[WebhookSetting]
    implicit val cpDecoder = deriveDecoder[CustomerPref]
    implicit val cpEncoder = deriveEncoder[CustomerPref]

    val customerJsonPref = Source.fromFile("CustomerPref.json").getLines.mkString
    //println(customerJsonPref)

    val customerPrefs = parse(customerJsonPref).map(_.as[List[CustomerPref]]) match {
      case Left(failure) => {
        println($"failure in parsing with $failure")
        List.empty[CustomerPref]
      }
      case Right(x) => x.getOrElse(List.empty)
    }

    //println(customerPrefs)


    IO(println(s"end of program")).as(ExitCode.Success)
  }
}