import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "org.alextanhongpin.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.code.gson:gson:2.8.5")
    compile("com.sparkjava:spark-core:2.3")?.let { implementation(it) }
    compile("com.sparkjava:spark-kotlin:1.0.0-alpha")?.let { implementation(it) }
    testCompile("org.slf4j:slf4j-simple:1.7.25")?.let { implementation(it) }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}