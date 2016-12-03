logLevel := Level.Warn

// https://github.com/sbt/sbt-native-packager
addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.1.5")

// to format scala source code
// https://github.com/sbt/sbt-scalariform
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

// Check whether dependencies can be updated (sbt dependencyUpdates)
// https://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.0")