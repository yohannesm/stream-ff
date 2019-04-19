package marcell.streamff
import io.circe.generic.{JsonCodec, auto}
import io.circe.syntax._

case class WebhookSetting (entity: String, event: String, endpoint: String)

case class CustomerPref(appCode: String, webhookSettings: List[WebhookSetting])

//implicit val WebhookSettingDecoder : Decoder[WebhookSetting] = deriveDecoder
