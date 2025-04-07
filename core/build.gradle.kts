import com.codereview.gradle.Deps

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.codereview.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.composeCompilerVersion
    }
}

dependencies {

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
    implementation(Deps.composeNavigation)
    implementation(Deps.timber)
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)

    androidTestImplementation(Deps.TestDeps.androidxEspressoCore)
    androidTestImplementation(Deps.TestDeps.jUnit)
    androidTestImplementation(Deps.TestDeps.androidxJUnit)
    androidTestImplementation(Deps.TestDeps.composeUiTest)

    implementation(Deps.coil)
}