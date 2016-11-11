name := """cashflow"""

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.bintrayRepo("hseeberger", "maven")
resolvers += "Flyway" at "https://flywaydb.org/repo"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.11"
libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % "2.4.11"
libraryDependencies += "de.heikoseeberger" %% "akka-http-circe" % "1.10.1"
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"
libraryDependencies += "org.flywaydb" % "flyway-core" % "4.0.3"
libraryDependencies += "joda-time" % "joda-time" % "2.9.4"
libraryDependencies += "org.joda" % "joda-convert" % "1.8.1"

lazy val doobieVersion = "0.3.0"
libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core",
  "org.tpolecat" %% "doobie-contrib-postgresql",
  "org.tpolecat" %% "doobie-contrib-specs2",
  "org.tpolecat" %% "doobie-contrib-hikari"
).map(_ % doobieVersion)

val circeVersion = "0.5.1"
libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
