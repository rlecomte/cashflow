package io.github.rlecomte.cashflow.db

import io.github.rlecomte.cashflow.model.CashFlow

trait CashFlowIO extends DbMeta {

  import doobie.imports._

  def getCashFlow: Query0[CashFlow] = {
    sql"select id, label, spent, dateof from cashflow".query[CashFlow]
  }

  def insertCashFlow(cashFlow: CashFlow): Update0 = {
    sql"insert into cashflow (id, label, spent, dateof) VALUES(${cashFlow.id}, ${cashFlow.label}, ${cashFlow.amount}, ${cashFlow.timestamp})".update
  }

}
