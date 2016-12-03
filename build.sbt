name := "fast-data"

organization := "nl.trivento"

version := "0.1"

resolvers += Resolver.jcenterRepo

val root = project.in(file(""))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings : _*)
  .settings(IntegrationConf.settings(orderHandler, sampler, sampleCollector, fetchHandler))
  .aggregate(common, orderHandler, sampler, sampleCollector, fetchHandler)
  .dependsOn(common % "compile->compile;test->test", orderHandler, sampler, sampleCollector, fetchHandler)
  .settings(DependenciesConf.akka)
  .settings(ReleaseConf.noPublishSettings)

lazy val common = project.in(file("common"))
  .settings(DependenciesConf.all)
  .settings(ReleaseConf.noPublishSettings)

lazy val orderHandler = project.in(file("order-handler"))
  .settings(DependenciesConf.all)
  .settings(DockerConf.settings)
  .dependsOn(common % "compile->compile;test->test")
  .enablePlugins(JavaAppPackaging)

lazy val sampler = project.in(file("sampler"))
  .settings(DependenciesConf.all)
  .settings(DockerConf.settings)
  .dependsOn(common % "compile->compile;test->test")
  .enablePlugins(JavaAppPackaging)

lazy val sampleCollector = project.in(file("sample-collector"))
  .settings(DependenciesConf.all)
  .settings(DockerConf.settings)
  .dependsOn(common % "compile->compile;test->test")
  .enablePlugins(JavaAppPackaging)

lazy val fetchHandler = project.in(file("fetch-handler"))
  .settings(DependenciesConf.all)
  .settings(DockerConf.settings)
  .dependsOn(common % "compile->compile;test->test")
  .enablePlugins(JavaAppPackaging)