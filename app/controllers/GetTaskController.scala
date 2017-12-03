package controllers

import javax.inject.{ Inject, Singleton }

import models.Task
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.mvc.{ Action, AnyContent, Controller }

@Singleton
class GetTaskController @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index(id: Long): Action[AnyContent] = Action { implicit request =>
    val message = Task.findById(id).get
    Ok(views.html.show(message))
  }

}
