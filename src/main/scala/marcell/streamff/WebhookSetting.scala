package marcell.streamff

case class WebhookSetting (entity: String, event: String, endpoint: String)

case class CustomerPref(appCode: String, webhookSettings: List[WebhookSetting])
