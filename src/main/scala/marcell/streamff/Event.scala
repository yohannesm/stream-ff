package marcell.streamff

sealed trait Entity

case class Reservation(id: Long, userId: Long, start: String, end: String) extends Entity

case class ServiceRequest(id: Long, roomId: Long, operatorId: Long) extends Entity

case class Event(appCode: String, entity: Entity, event: String)
