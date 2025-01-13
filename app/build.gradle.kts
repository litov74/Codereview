import com.codereview.gradle.Deps

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.codereview"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.codereview"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        if (project.findProperty("enableComposeReports") == "true") {
            freeCompilerArgs += listOf(
                "-P",
                "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=${project.buildDir.absolutePath}/compose-reports",
                "-P",
                "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=${project.buildDir.absolutePath}/compose-reports"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.composeCompilerVersion
    }
    packagingOptions {
        jniLibs {
            useLegacyPackaging = true
        }
        resources {
            excludes += setOf("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(Deps.composeNavigation)
    implementation(Deps.androidViewModelScope)
    implementation(Deps.androidxCore)
    implementation(Deps.androidxAppCompat)
    implementation(Deps.googleMaterial)
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composeUiTooling)
    implementation(Deps.lifecycleRuntime)
    implementation(Deps.activityCompose)
    implementation(Deps.composeMaterial3)
    implementation(Deps.androidLifecycleCompose)
    implementation(Deps.hiltNavigation)
    implementation(Deps.kotlinCollectionsImmutable)
    implementation(Deps.composeMaterial3Navigation)
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)


    androidTestImplementation(Deps.TestDeps.androidxEspressoCore)
    androidTestImplementation(Deps.TestDeps.jUnit)
    androidTestImplementation(Deps.TestDeps.androidxJUnit)
    androidTestImplementation(Deps.TestDeps.composeUiTest)
}