package marcell.streamff

object UriResolver {

  def UriMapBuilder(CustomerPrefs: List[CustomerPref]) : Map[String, String] = {
    var uriMap = collection.mutable.Map[String, String]()
    val bla = for(customerPref <- CustomerPrefs) {
      val builder = StringBuilder.newBuilder
      for(webhookSetting <- customerPref.webhookSettings) {
        builder.append(customerPref.appCode.toLowerCase())
        builder.append(webhookSetting.entity.toLowerCase())
        builder.append(webhookSetting.event.toLowerCase())
        uriMap += (builder.toString() -> webhookSetting.endpoint)
        builder.clear()
      }
    }
    uriMap.toMap
  }

  def formKey(appCode: String, entityType: String, event: String): String = {
    s"${appCode.toLowerCase()}${entityType.toLowerCase()}${event.toLowerCase()}"
  }
}
