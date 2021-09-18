plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.kotlin.plugin.noarg")
    `maven-publish`
}


repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
}

val coroutinesVersion: String by project
val serializationVersion: String by project
val xodusVersion: String by project
val zstVersion: String by project
val apacheCompressVersion: String by project
val fstVersion: String by project
val kryoVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.30")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.30")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("de.ruedigermoeller:fst:$fstVersion")
    implementation("com.esotericsoftware:kryo:$kryoVersion")
    implementation("org.apache.commons:commons-compress:$apacheCompressVersion")
    implementation("com.github.luben:zstd-jni:$zstVersion")
    implementation("org.jetbrains.xodus:xodus-entity-store:$xodusVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.5.30")
}

java.targetCompatibility = JavaVersion.VERSION_1_8

kotlin {
    target {
        compilations.all { kotlinOptions.jvmTarget = "${project.java.targetCompatibility}" }
    }
    listOf(
        "kotlin.Experimental",
        "kotlinx.serialization.ImplicitReflectionSerializer",
        "kotlinx.serialization.InternalSerializationApi",
        "kotlinx.serialization.ExperimentalSerializationApi"
    ).let { annotations ->
        sourceSets.all { annotations.forEach(languageSettings::optIn) }
    }
}

noArg {
    annotation("kotlinx.serialization.Serializable")
}



tasks.getByName<Test>("test") {
    useJUnit()
}
