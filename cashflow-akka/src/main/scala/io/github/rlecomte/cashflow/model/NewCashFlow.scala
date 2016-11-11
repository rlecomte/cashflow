package io.github.rlecomte.cashflow.model

import org.joda.time.{DateTime, DateTimeZone}

import io.github.rlecomte.cashflow.util.UUIDGen

case class NewCashFlow(label: String, amount: BigDecimal) {

  def toCashFlowIO = CashFlow(
    id = CashFlowID(UUIDGen.next()),
    label = label,
    amount = amount,
    timestamp = new DateTime(DateTimeZone.UTC)
  )
}