name := """scadashboard"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  ws,
  "com.github.dwhjames" %% "aws-wrap" % "0.7.2",
  "com.amazonaws" % "aws-java-sdk-cloudwatch" % "1.10.0",
  "com.amazonaws" % "aws-java-sdk-ec2" % "1.10.0",
  "net.codingwell" %% "scala-guice" % "4.0.0-beta5",
  specs2 % Test
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// Scala settings
scalacOptions ++= Seq("-encoding", "utf8") // Ensure that files are compiled in utf8
scalacOptions ++= Seq(
  "-deprecation",           // Warn when deprecated API are used
  "-feature",               // Warn for usages of features that should be importer explicitly
  "-unchecked",             // Warn when generated code depends on assumptions
  "-Ywarn-dead-code",       // Warn when dead code is identified
  "-Ywarn-numeric-widen"    // Warn when numeric are widened
)
scalacOptions in (Compile, compile) ++= Seq( // Disable for tests
  "-Xlint",                 // Additional warnings (see scalac -Xlint:help)
  "-Ywarn-adapted-args"     // Warn if an argument list is modified to match the receive
)
