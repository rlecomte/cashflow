package io.github.rlecomte

import scala.language.implicitConversions
import scalaz.concurrent.Task

import doobie.imports._

package object cashflow {

  val defaultDoobieTransactor = DriverManagerTransactor[Task](
    "org.postgresql.Driver",
    "jdbc:postgresql://127.0.0.1:5432/world",
    "postgres",
    null
  )

  type UUID = java.util.UUID
}
