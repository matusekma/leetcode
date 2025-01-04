import org.gradle.kotlin.dsl.invoke

plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "hu.matusek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}