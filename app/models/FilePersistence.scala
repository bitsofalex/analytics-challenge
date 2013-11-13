package models

import play.api.libs.json._
import scala.reflect.io.Path

trait FilePersistence {
  
  def write = {
    val to = this match {
      case s: Start => Json.stringify(Json.obj("start" -> s))
      case e: End => Json.stringify(Json.obj("end" -> e))
    }
    Path("output/events").toFile.appendAll(to + "\n")
  }

}