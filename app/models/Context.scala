package models

import play.api.libs.json._

case class Build(version: String, code: Int)

object Build {
  implicit val format = Json.format[Build]
}


case class Context(build: Option[Build], location: Option[Location])

object Context {
  implicit val format = Json.format[Context]
}