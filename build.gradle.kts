import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage
import com.bmuschko.gradle.docker.tasks.image.Dockerfile
import com.bmuschko.gradle.docker.tasks.image.Dockerfile.CopyFileInstruction

plugins {
  kotlin("jvm")
  kotlin("plugin.serialization")
  application
  id("com.bmuschko.docker-java-application")
}

group = "org.jraf"
version = "1.0.0"


repositories {
  mavenCentral()
}

kotlin {
  jvmToolchain(11)
}

dependencies {
  // Slf4j
  implementation("org.slf4j:slf4j-api:_")
  implementation("org.slf4j:slf4j-simple:_")

  // Playwright
  implementation("com.microsoft.playwright:playwright:_")

  // Serialization
  implementation(KotlinX.serialization.json)

  // Ktor server
  implementation(Ktor.server.core)
  implementation(Ktor.server.cio)
  implementation(Ktor.server.statusPages)
  implementation(Ktor.server.callLogging)

  // Ktor client
  implementation(Ktor.client.core)
  implementation(Ktor.client.contentNegotiation)
  implementation(Ktor.client.auth)
  implementation(Ktor.client.logging)
  implementation(Ktor.plugins.serialization.kotlinx.json)
  implementation(Ktor.client.okHttp)

  // RSS
  implementation("com.rometools:rome:_")

  // Tests
  testImplementation(Kotlin.test)
}

application {
  mainClass.set("MainKt")
}

docker {
  javaApplication {
    // Use OpenJ9 instead of the default one
    baseImage.set("adoptopenjdk/openjdk11-openj9:x86_64-ubuntu-jre-11.0.18_10_openj9-0.36.1")
    maintainer.set("BoD <BoD@JRAF.org>")
    ports.set(listOf(8080))
    images.add("bodlulu/${rootProject.name}:latest")
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
  environmentVariable("PLAYWRIGHT_BROWSERS_PATH", "/playwright-browsers")

  // Install browser dependencies
  runCommand("apt-get update")
  runCommand(
    """
    apt-get install -y \
      libxcb-shm0\
      libx11-xcb1\            
      libx11-6\               
      libxcb1\                
      libxext6\               
      libxrandr2\             
      libxcomposite1\         
      libxcursor1\            
      libxdamage1\            
      libxfixes3\             
      libxi6\                 
      libgtk-3-0\             
      libpangocairo-1.0-0\    
      libpango-1.0-0\         
      libatk1.0-0\            
      libcairo-gobject2\      
      libcairo2\              
      libgdk-pixbuf2.0-0\     
      libglib2.0-0\           
      libasound2\             
      libxrender1\            
      libdbus-1-3
     """.trimIndent()
  )

  // Move the COPY instructions to the end
  // See https://github.com/bmuschko/gradle-docker-plugin/issues/1093
  instructions.set(
    instructions.get().sortedBy { instruction ->
      if (instruction.keyword == CopyFileInstruction.KEYWORD) 1 else 0
    }
  )

}

tasks.test {
  useJUnitPlatform()
}

// `./gradlew refreshVersions` to update dependencies
// `DOCKER_USERNAME=<your docker hub login> DOCKER_PASSWORD=<your docker hub password> ./gradlew dockerPushImage` to build and push the image
