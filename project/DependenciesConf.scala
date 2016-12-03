import sbt.Keys._
import sbt._


object DependenciesConf {

  val akkaVersion = "2.4.14"
  val akkaHttpVersion = "10.0.0"
  val sparkVersion = "2.0.2"

  lazy val scala: Seq[Setting[_]] = Seq(
    scalaVersion := "2.11.8"
  )

  lazy val common: Seq[Setting[_]] = scala ++ Seq(
    libraryDependencies ++= commonDeps
  )

  lazy val akka: Seq[Setting[_]] = common ++ Seq(
    libraryDependencies ++= akkaDeps
  )

  lazy val spark: Seq[Setting[_]] = common ++ Seq(
    libraryDependencies ++= sparkDeps
  )

  lazy val all: Seq[Setting[_]] = scala ++ Seq(
    libraryDependencies ++= commonDeps ++ akkaDeps ++ sparkDeps
  )

  lazy val commonDeps = Seq(
    "org.scalaz" %% "scalaz-core" % "7.2.8",
    "commons-io" % "commons-io" % "2.5",
    "com.iheart" %% "ficus" % "1.4.0",
    "ch.qos.logback" % "logback-classic" % "1.1.7",

    "org.scalatest" %% "scalatest" % "3.0.1" % Test,
    "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
    "org.typelevel" %% "scalaz-scalatest" % "1.1.1" % Test
  )

  lazy val akkaDeps = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
  )

  lazy val sparkDeps = Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion exclude("org.slf4j", "slf4j-log4j12") exclude("org.sl4fj", "slf4j-nop"),
    "org.apache.spark" %% "spark-sql" % sparkVersion exclude("org.slf4j", "slf4j-log4j12") exclude("org.sl4fj", "slf4j-nop"),
    "org.apache.spark" %% "spark-tags" % sparkVersion exclude("org.slf4j", "slf4j-log4j12") exclude("org.sl4fj", "slf4j-nop"),
    "org.apache.spark" %% "spark-streaming" % sparkVersion exclude("org.slf4j", "slf4j-log4j12") exclude("org.sl4fj", "slf4j-nop")
  )
}