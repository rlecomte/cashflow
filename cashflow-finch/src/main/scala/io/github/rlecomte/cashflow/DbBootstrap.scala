package io.github.rlecomte.cashflow

import org.flywaydb.core.Flyway

object DbBootstrap extends Flyway{
  setDataSource("jdbc:postgresql://127.0.0.1:5432/world", "postgres", null)
}
