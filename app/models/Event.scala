package models

import play.api.libs.json._

abstract class Event
abstract class FilePersistedEvent extends Event with FilePersistence
case class Start(app_id: String, device_id: String, timestamp: String, context: Option[Context]) extends FilePersistedEvent
case class End(app_id: String, device_id: String, timestamp: String, context: Option[Context]) extends FilePersistedEvent

object Start {
  implicit val format = Json.format[Start]
}
object End {
  implicit val format = Json.format[End]
}

case class Events(starts: Option[List[Start]], ends: Option[List[End]])

object Events {
  implicit val format = Json.format[Events]
}