import com.typesafe.sbt.SbtNativePackager.autoImport._
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging.autoImport._
import com.typesafe.sbt.packager.docker.Cmd
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import sbt.Keys._
import sbt._


object DockerConf {

  lazy val settings: Seq[Setting[_]] = Seq(
    mainClass in Compile := Some("nl.trivento"),
    dockerCommands := dockerCommands.value.filterNot {
      // ExecCmd is a case class, and args is a varargs variable, so you need to bind it with @
      case Cmd("USER", args@_*) => true
      // dont filter the rest
      case cmd => false
    },

    dockerExposedPorts := Seq(8080),
    maintainer in Docker := "info@trivento.nl",
    dockerUpdateLatest := true,
    dockerBaseImage := "java-filebeat:latest",
    packageName in Docker := name.value.toLowerCase,
    // configure sbt-native-package to use config
    bashScriptExtraDefines += """addJava "-Dconfig.file=${app_home}/../conf/application.conf""""
  )
}