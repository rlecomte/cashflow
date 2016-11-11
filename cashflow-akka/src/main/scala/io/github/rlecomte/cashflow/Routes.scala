package io.github.rlecomte.cashflow

import scala.concurrent.duration.Duration
import scala.concurrent.Await
import scala.io.StdIn
import scalaz.concurrent.Task

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.{ActorMaterializer, Materializer}

import io.circe.syntax._
import de.heikoseeberger.akkahttpcirce.CirceSupport._
import io.circe.generic.auto._
import io.github.rlecomte.cashflow.db.CashFlowIO
import io.github.rlecomte.cashflow.model.NewCashFlow
import io.github.rlecomte.cashflow.util.CustomMagnets

object Routes extends App with CustomMagnets with CashFlowIO {

  import doobie.imports._

  val tx = defaultDoobieTransactor

  implicit val system = ActorSystem("cashflow-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  def route(implicit mat: Materializer) = {
    path("cashflow") {
      post {
        entity(as[NewCashFlow]) { newCashflow =>
          onSuccess(insertCashFlow(newCashflow.toCashFlowIO).run.transact(tx)) { e =>
            complete()
          }
        }
      } ~
      get {
        onSuccess(getCashFlow.process.list.transact(tx)) { e =>
          complete(e.asJson.noSpaces)
        }
      }
    }
  }

  DbBootstrap.migrate()
  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  StdIn.readLine("Hit ENTER to exit")
  Await.ready(system.terminate(), Duration.Inf)
}