package marcell.streamff

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._

object Main extends IOApp {
  //def run(args: List[String]) =
  // StreamffServer.stream[IO].compile.drain.as(ExitCode.Success)
  def run(args: List[String]) = {
    IO(println(s"end of program")).as(ExitCode.Success)
  }
}