package io.github.rlecomte.cashflow.model

import org.joda.time.DateTime

import io.circe._
import io.circe.syntax._

case class CashFlow(id: CashFlowID, label: String, amount: BigDecimal, timestamp: DateTime)

object CashFlow {
  implicit val encode = new Encoder[CashFlow] {
    final def apply(a: CashFlow): Json = Json.obj(
      "id" -> a.id.toString.asJson,
      "label" -> a.label.asJson,
      "amount" -> a.amount.asJson,
      "timestamp" -> a.timestamp.getMillis.asJson
    )
  }
}