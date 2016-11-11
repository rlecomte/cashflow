package io.github.rlecomte.cashflow.db

import org.joda.time.{DateTime, DateTimeZone}

import doobie.imports._
import io.github.rlecomte.cashflow.UUID
import io.github.rlecomte.cashflow.model.CashFlowID

trait DbMeta {

  import doobie.contrib.postgresql.pgtypes.UuidType

  implicit val cashflowIdMeta: Meta[CashFlowID] = Meta[UUID].xmap(CashFlowID.apply, _.id)
  implicit val datetimeMeta: Meta[DateTime] = Meta[java.sql.Timestamp].nxmap(t => new DateTime(t.getTime, DateTimeZone.UTC), d => new java.sql.Timestamp(d.getMillis))
}
