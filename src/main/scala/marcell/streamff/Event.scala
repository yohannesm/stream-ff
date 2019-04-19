package marcell.streamff

case class Reservation(id: Long, userId: Long, start: String, end: String)

case class ServiceRequest(id: Long, roomId: Long, operatorId: Long)

case class Event(appCode: String, entity: Either[Reservation, ServiceRequest], event: String)
