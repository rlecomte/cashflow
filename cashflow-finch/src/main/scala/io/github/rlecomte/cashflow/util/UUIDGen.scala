package io.github.rlecomte.cashflow.util

object UUIDGen {
  val zero = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")
  def next() = java.util.UUID.randomUUID()
}