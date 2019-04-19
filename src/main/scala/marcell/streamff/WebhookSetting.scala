package marcell.streamff
import io.circe.generic.{JsonCodec, auto}
import io.circe.syntax._

case class WebhookSetting (entity: String, event: String, endpoint: String)


