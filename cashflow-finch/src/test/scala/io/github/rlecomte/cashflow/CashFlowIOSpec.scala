package io.github.rlecomte.cashflow

import scalaz.concurrent.Task

import org.joda.time.DateTime
import org.specs2.mutable.Specification

import doobie.contrib.specs2.analysisspec.AnalysisSpec
import doobie.util.transactor.Transactor
import io.github.rlecomte.cashflow.db.CashFlowIO
import io.github.rlecomte.cashflow.model.{CashFlow, CashFlowID}
import io.github.rlecomte.cashflow.util.UUIDGen

class CashFlowIOSpec extends Specification with AnalysisSpec with CashFlowIO {

  override def transactor: Transactor[Task] = defaultDoobieTransactor

  DbBootstrap.clean()
  DbBootstrap.migrate()

  check(getCashFlow)

  check(insertCashFlow(CashFlow(
    id = CashFlowID(UUIDGen.zero),
    label = "buy a bike",
    amount = BigDecimal(50.2),
    timestamp = new DateTime(0)
  )))
  
}
