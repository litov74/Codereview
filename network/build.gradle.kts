import com.codereview.gradle.Deps

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "2.1.0"
    id("kotlin-kapt")
}

android {
    namespace = "com.codereview.network"
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
}

dependencies {

    implementation(Deps.androidxCore)
    implementation(Deps.kotlinCollectionsImmutable)
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)

    implementation(Deps.retrofit)
    implementation(Deps.retrofitConverterGson)
    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutinesAndroid)
    debugImplementation(Deps.chucker)
    releaseImplementation(Deps.chuckerRelease)
    implementation(Deps.kotlinSerialization)
    implementation(Deps.serializationConverter)
    implementation(Deps.okHttp)
    implementation(Deps.okHttpLoggingInterceptor)

    testImplementation(Deps.TestDeps.jUnit)
    androidTestImplementation(Deps.TestDeps.androidxJUnit)
    androidTestImplementation(Deps.TestDeps.androidxEspressoCore)
}