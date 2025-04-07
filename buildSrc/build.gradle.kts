plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://plugins.gradle.org/m2/")
    maven("https://ci.android.com/builds/submitted/5837096/androidx_snapshot/latest/repository")
}

object PluginsVersions {
    const val GRADLE_ANDROID = "8.1.3"
    const val KOTLIN = "1.9.23"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${PluginsVersions.KOTLIN}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")

    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("com.squareup:javapoet:1.13.0")
}