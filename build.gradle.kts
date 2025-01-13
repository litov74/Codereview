import com.codereview.gradle.Deps

buildscript {

    val kotlinVersion by extra("1.9.23")
    val composeVersion by extra("1.3.2")

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.46")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://developer.huawei.com/repo/")
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.register("printAllDeps") {
    doLast {
        Deps.allLibraries.forEach { dependency ->
            println(dependency)
        }
    }
}