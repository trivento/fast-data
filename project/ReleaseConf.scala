import sbt.Keys._
import sbt._


object ReleaseConf {

  lazy val noPublishSettings = Seq(
    publish := (),
    publishLocal := (),
    publishArtifact := false
  )
}