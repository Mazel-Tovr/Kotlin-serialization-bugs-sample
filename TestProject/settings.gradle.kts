rootProject.name = "TestProject"

pluginManagement {
    val kotlinVersion: String by settings
    val licenseVersion: String by extra
    val kotlinNoarg: String by extra
    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.noarg") version kotlinNoarg
    }

    repositories {
        maven("https://dl.bintray.com/kotlin/kotlinx")
        maven("https://plugins.gradle.org/m2/")
        mavenLocal()
        jcenter()
        mavenCentral()
    }
}
