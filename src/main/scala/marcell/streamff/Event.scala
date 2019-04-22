package marcell.streamff
import cats.syntax.functor._
import io.circe.{Decoder, Encoder, Json}
import io.circe.generic.auto._
import io.circe.syntax._

sealed trait Entity

case class Reservation(id: Long, userId: Long, start: String, end: String)
    extends Entity

case class ServiceRequest(id: Long, roomId: Long, operatorId: Long)
    extends Entity

case class Event(appCode: String, entity: Entity, event: String)

object EntityDerivation {
  implicit val encodeEntity: Encoder[Entity] = Encoder.instance {
    case reservation @ Reservation(id, userId, start, end) =>
      Json.fromFields(
        List(("id", Json.fromLong(id)),
             ("userId", Json.fromLong(userId)),
             ("start", Json.fromString(start)),
             ("end", Json.fromString(end))))
    case serviceRequest @ ServiceRequest(id, roomId, operatorId) =>
      Json.fromFields(
        List(("id", Json.fromLong(id)),
             ("roomId", Json.fromLong(roomId)),
             ("operatorId", Json.fromLong(operatorId))))
  }

  implicit val decodeEntity: Decoder[Entity] =
    List[Decoder[Entity]](
      Decoder[Reservation].widen,
      Decoder[ServiceRequest].widen
    ).reduceLeft(_ or _ )

}
