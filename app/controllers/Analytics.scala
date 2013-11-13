package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.libs.json.Json

object Analytics extends Controller {

  def start = Action(parse.json) { request =>
    request.body.validate[Start].map {
      case e: Start => {
        e.write
        Ok(Json.obj())
      }
    }.recoverTotal {
      e => BadRequest(e.toString)
    }
  }
  
  def end = Action(parse.json) { request =>
    request.body.validate[End].map {
      case e: End => {
        e.write
        Ok(Json.obj())
      }
    }.recoverTotal {
      e => BadRequest("")
    }
  }
  
  def batch = Action(parse.json) { request =>
    request.body.validate[Events].map {
      case e: Events => {
        e.starts.map(_.foreach(_.write))
        e.ends.map(_.foreach(_.write))
        Ok(Json.obj())
      }
    }.recoverTotal {
      e => BadRequest("")
    }
  }
}