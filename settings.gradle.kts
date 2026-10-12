rootProject.name = "edf-to-rss"

pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
}

dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositories {
    mavenCentral()
    mavenLocal()
  }
}

plugins {
  // See https://github.com/gradle/foojay-toolchains
  id("org.gradle.toolchains.foojay-resolver-convention").version("1.0.0")

  // See https://splitties.github.io/refreshVersions/
  id("de.fayard.refreshVersions").version("0.60.6")
}
