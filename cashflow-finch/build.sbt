name := """cashflow-finch"""

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Flyway" at "https://flywaydb.org/repo"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
libraryDependencies += "org.flywaydb" % "flyway-core" % "4.0.3"
libraryDependencies += "joda-time" % "joda-time" % "2.9.4"
libraryDependencies += "org.joda" % "joda-convert" % "1.8.1"

lazy val finchVersion = "0.11.0-M4"
libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core",
  "com.github.finagle" %% "finch-circe",
  "com.github.finagle" %% "finch-test"
).map(_ % finchVersion)

lazy val doobieVersion = "0.3.0"
libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core",
  "org.tpolecat" %% "doobie-contrib-postgresql",
  "org.tpolecat" %% "doobie-contrib-specs2",
  "org.tpolecat" %% "doobie-contrib-hikari"
).map(_ % doobieVersion)

val circeVersion = "0.5.3"
libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
