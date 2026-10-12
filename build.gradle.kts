
import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage
import com.bmuschko.gradle.docker.tasks.image.Dockerfile
import com.bmuschko.gradle.docker.tasks.image.Dockerfile.CopyFileInstruction

plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.kotlin.serialization)
  application
  alias(libs.plugins.dockerJavaApplication)
}

group = "org.jraf"
version = "1.0.0"

kotlin {
  jvmToolchain(25)
}
application {
  mainClass.set("MainKt")
}

dependencies {
  // Logging
  implementation(libs.klibnanolog)
  implementation(libs.logback)

  // Playwright
  implementation(libs.playwright)

  // Serialization
  implementation(libs.kotlinx.serialization.json)

  // Ktor server
  implementation(libs.ktor.server.core)
  implementation(libs.ktor.server.cio)
  implementation(libs.ktor.server.statusPages)
  implementation(libs.ktor.server.callLogging)

  // Ktor client
  implementation(libs.ktor.client.core)
  implementation(libs.ktor.client.contentNegotiation)
  implementation(libs.ktor.client.auth)
  implementation(libs.ktor.client.logging)
  implementation(libs.ktor.serialization.kotlinx.json)
  implementation(libs.ktor.client.okhttp)

  // RSS
  implementation(libs.rome)
}


docker {
  javaApplication {
    baseImage.set("eclipse-temurin:25")
    maintainer.set("BoD <BoD@JRAF.org>")
    ports.set(listOf(8080))
    images.add("bodlulu/${rootProject.name.lowercase()}:latest")
    jvmArgs.set(listOf("-Xms16m", "-Xmx128m"))
  }
  registryCredentials {
    username.set(System.getenv("DOCKER_USERNAME"))
    password.set(System.getenv("DOCKER_PASSWORD"))
  }
}

tasks.withType<DockerBuildImage> {
  platform.set("linux/amd64")
}

tasks.withType<Dockerfile> {
  // Install browser dependencies and curl
  runCommand("apt-get update")
  runCommand(
    """
      apt-get install -y \
        curl \
        libxcb-shm0 \
        libx11-xcb1 \
        libxrandr2 \
        libxcomposite1 \
        libxcursor1 \
        libxdamage1 \
        libxi6 \
        libxext6 \
        libxfixes3 \
        libx11-6 \
        libxcb1 \
        libgtk-3-0t64 \
        libpangocairo-1.0-0 \
        libpango-1.0-0 \
        libatk1.0-0t64 \
        libcairo-gobject2 \
        libcairo2 \
        libgdk-pixbuf-2.0-0 \
        libglib2.0-0t64 \
        libxrender1 \
        libasound2t64 \
        libdbus-1-3
     """.trimIndent()
  )

  // Download the OpenTelemetry Java agent
  runCommand("curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar")

  // Playwright configuration
  environmentVariable("PLAYWRIGHT_BROWSERS_PATH", "/playwright-browsers")

  // OpenTelemetry Java agent configuration
  environmentVariable(
    mapOf(
      "JAVA_TOOL_OPTIONS" to "-javaagent:opentelemetry-javaagent.jar",
      "OTEL_SERVICE_NAME" to rootProject.name.lowercase(),
    )
  )

  // Move the COPY instructions to the end
  // See https://github.com/bmuschko/gradle-docker-plugin/issues/1093
  instructions.set(
    instructions.get().sortedBy { instruction ->
      if (instruction.keyword == CopyFileInstruction.KEYWORD) 1 else 0
    }
  )
}

// `./gradlew refreshVersions` to update dependencies
// `DOCKER_USERNAME=<your docker hub login> DOCKER_PASSWORD=<your docker hub password> ./gradlew dockerPushImage` to build and push the image
