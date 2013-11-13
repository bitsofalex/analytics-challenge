package models

import play.api.libs.json._

case class Location(latitude: Float, longitude: Float)

object Location {
  implicit val format = Json.format[Location]
}