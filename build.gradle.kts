import enforcer.rules.DependencyConvergence
import enforcer.rules.RequireGradleVersion
import enforcer.rules.RequireJavaVersion
import kotlinx.kover.api.CoverageEngine
import kotlinx.kover.api.KoverTaskExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.kordamp.gradle.plugin.enforcer.api.EnforcerPhase.BEFORE_BUILD
import org.kordamp.gradle.plugin.enforcer.api.EnforcerPhase.BEFORE_PROJECT

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    id("org.kordamp.gradle.project-enforcer") version "0.9.0"
    id("info.solidsoft.pitest") version "1.7.0"
    id("se.bjurr.gitchangelog.git-changelog-gradle-plugin") version "1.71.4"
    id("org.jetbrains.kotlinx.kover") version "0.4.2"
}

group = "personal"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2021.0.4"
extra["testcontainersVersion"] = "1.16.2"
extra["springBootVersion"] = "2.5.4"
extra["springDocOpenApiVersion"] = "1.6.11"
extra["karateVersion"] = "0.9.6"
extra["karateJUnit"] = "1.2.1.RC2"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("org.springdoc:springdoc-openapi-kotlin:${property("springDocOpenApiVersion")}")
    implementation("org.springdoc:springdoc-openapi-data-rest:${property("springDocOpenApiVersion")}")
    implementation("org.springdoc:springdoc-openapi-ui:${property("springDocOpenApiVersion")}")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mockserver")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
    testImplementation("io.kotest:kotest-runner-junit5:4.6.3")
    testImplementation("io.kotest:kotest-extensions-spring:4.4.3")
    testImplementation("io.kotest.extensions:kotest-extensions-pitest:1.0.1")
    testImplementation("com.ninja-squad:springmockk:3.0.1")
    testImplementation("com.intuit.karate:karate-apache:${property("karateVersion")}")
    testImplementation("com.intuit.karate:karate-junit5:${property("karateJUnit")}")
    testImplementation("org.mock-server:mockserver-client-java:5.7.2")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        mavenBom("org.springframework.boot:spring-boot-starter-parent:${property("springBootVersion")}")
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

enforce {
    rule(DependencyConvergence::class.java) {
        phases.set(listOf(BEFORE_PROJECT))
    }
    rule(RequireJavaVersion::class.java) {
        version.set("[11,12)")
        phases.set(listOf(BEFORE_BUILD))
    }
    rule(RequireGradleVersion::class.java) {
        version.set("[7.0,7.2]")
    }
}

pitest {
    testPlugin.set("Kotest")
    outputFormats.set(setOf("XML", "HTML"))
    targetClasses.set(setOf("personal.videogames.*"))
}

sourceSets {
    test {
        resources {
            srcDirs("src/test/kotlin")
            exclude("**/*.kt")
        }
    }
}

tasks.compileJava {
    enabled = false
}

tasks.test {
    useJUnitPlatform()
    extensions.configure(KoverTaskExtension::class) {
        isEnabled = true
    }
    finalizedBy(tasks.koverVerify, tasks.koverReport)
}

kover {
    isEnabled = true
    coverageEngine.set(CoverageEngine.JACOCO)
    jacocoEngineVersion.set("0.8.7")
}

tasks.koverHtmlReport {
    isEnabled = true
    htmlReportDir.set(layout.buildDirectory.dir("reports/kover/html"))
}

tasks.koverXmlReport {
    isEnabled = true
    xmlReportFile.set(layout.buildDirectory.file("reports/kover/xml/test-results.xml"))
}

tasks.koverVerify {
    rule {
        name = "Minimum line coverage percentage rate"
        bound {
            minValue = 30
        }
    }
}
