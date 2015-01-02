uniform.project("omnia-test", "au.com.cba.omnia.omnia.test")

uniformDependencySettings

libraryDependencies :=
  depend.time() ++ depend.testing() ++ Seq(
    "org.specs2"     %% "specs2"     % depend.versions.specs,
    "org.scalacheck" %% "scalacheck" % depend.versions.scalacheck
  )

updateOptions := updateOptions.value.withCachedResolution(true)

uniform.docSettings("https://github.com/CommBank/omnia-test")

uniform.ghsettings
