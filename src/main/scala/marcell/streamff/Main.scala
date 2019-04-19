package marcell.streamff

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import io.circe.fs2._
import io.circe._
import io.circe.parser._

import scala.io.Source

object Main extends IOApp {
  //def run(args: List[String]) =
  // StreamffServer.stream[IO].compile.drain.as(ExitCode.Success)
  def run(args: List[String]) = {

    val customerJsonPref = Source.fromFile("CustomerPref.json").getLines.mkString
    //println(customerJsonPref)

    val parsedJson = parse(customerJsonPref)
    println(parsedJson)


    IO(println(s"end of program")).as(ExitCode.Success)
  }
}