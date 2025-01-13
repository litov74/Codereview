package com.codereview.gradle

object Deps {

    const val kotlinPlugin = Plugins.kotlinPlugin
    const val androidGradlePlugin = Plugins.androidGradlePlugin
    const val hiltPlugin = Plugins.hiltPlugin

    const val coroutinesCore = Libraries.coroutinesCore
    const val coroutinesAndroid = Libraries.coroutinesAndroid
    const val androidLifecycleScope = Libraries.androidLifecycleScope
    const val androidViewModelScope = Libraries.androidViewModelScope
    const val androidLifecycleCompose = Libraries.androidLifecycleCompose
    const val kotlinStdLib = Libraries.kotlinStdLib
    const val androidxCore = Libraries.androidxCore
    const val androidxAppCompat = Libraries.androidxAppCompat
    const val googleMaterial = Libraries.googleMaterial
    const val composeUi = Libraries.composeUi
    const val composeMaterial = Libraries.composeMaterial
    const val composeUiTooling = Libraries.composeUiTooling
    const val lifecycleRuntime = Libraries.lifecycleRuntime
    const val activityCompose = Libraries.activityCompose
    const val composeMaterial3 = Libraries.composeMaterial3
    const val composeMaterial3Navigation = Libraries.composeMaterial3Navigation
    const val composeNavigation = Libraries.composeNavigation
    const val hiltNavigation = Libraries.hiltNavigation
    const val kotlinCollectionsImmutable = Libraries.kotlinCollectionsImmutable

    const val retrofit = Libraries.retrofit
    const val retrofitConverterGson = Libraries.retrofitConverterGson
    const val okHttp = Libraries.okHttp
    const val okHttpLoggingInterceptor = Libraries.okHttpLoggingInterceptor
    const val chucker = Libraries.chucker
    const val chuckerRelease = Libraries.chuckerRelease
    const val kotlinSerialization = Libraries.kotlinSerialization
    const val serializationConverter = Libraries.serializationConverter

    const val dagger = Libraries.dagger
    const val daggerKapt = Libraries.daggerKapt
    const val hilt = Libraries.hilt
    const val hiltKapt = Libraries.hiltKapt

    const val roomRuntime = Libraries.roomRuntime
    const val roomKapt = Libraries.roomKapt
    const val roomKtx = Libraries.roomKtx

    const val timber = Libraries.timber

    const val gson = Libraries.gson

    const val coil = Libraries.coil

    const val integrationLibrary = Libraries.integrationLibrary

    internal const val kotlinVersion = "1.9.23"
    const val composeCompilerVersion = "1.5.13"
    const val composeUiTestVersion = "1.6.8"

    val allLibraries = listOf(
        kotlinPlugin,
        androidGradlePlugin,
        coroutinesAndroid,
        coroutinesCore,
        androidLifecycleScope,
        androidViewModelScope,
        androidLifecycleCompose,
        kotlinStdLib,
        androidxCore,
        androidxAppCompat,
        retrofit,
        retrofitConverterGson,
        okHttp,
        okHttpLoggingInterceptor,
        dagger,
        daggerKapt,
        hilt,
        hiltKapt,
        roomKapt,
        roomKtx,
        roomRuntime,
        timber,
        gson,
        coil,
        googleMaterial,
        composeUi,
        composeMaterial,
        composeUiTooling,
        activityCompose,
        lifecycleRuntime,
        hiltPlugin,
        composeMaterial3,
        composeMaterial3Navigation,
        composeNavigation,
        hiltNavigation,
        kotlinCollectionsImmutable
    )

    object TestDeps {
        const val jUnit = "junit:junit:4.13.2"
        const val androidxJUnit = "androidx.test.ext:junit:1.1.5"
        const val androidxEspressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${composeUiTestVersion}"

    }

    private object Libraries {
        private const val coroutinesPrefix = "org.jetbrains.kotlinx:kotlinx-coroutines"
        private const val androidLifecyclePrefix = "androidx.lifecycle:lifecycle"
        private const val daggerPrefix = "com.google.dagger:dagger"
        private const val retrofitPrefix = "com.squareup.retrofit2:"
        private const val okHttpPrefix = "com.squareup.okhttp3:"
        private const val roomPrefix = "androidx.room:room"
        const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.composeUi}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeUi}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val composeMaterial3 = "androidx.compose.material3:material3:1.3.0"
        const val composeMaterial3Navigation = "androidx.compose.material3:material3-adaptive-navigation-suite-android:1.3.0-rc01"
        const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}"
        const val kotlinCollectionsImmutable = "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.kotlinCollections}"

        const val coroutinesCore = "$coroutinesPrefix-core:${Versions.coroutinesCore}"
        const val coroutinesAndroid = "$coroutinesPrefix-android:${Versions.coroutinesCore}"

        const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
        const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
        const val androidLifecycleScope = "$androidLifecyclePrefix-runtime-ktx:${Versions.kotlinLifecycle}"
        const val androidViewModelScope = "$androidLifecyclePrefix-viewmodel-ktx:${Versions.kotlinLifecycle}"
        const val androidLifecycleCompose = "$androidLifecyclePrefix-runtime-compose:${Versions.lifecycle}"
        const val dagger = "$daggerPrefix:${Versions.dagger}"
        const val daggerKapt = "$daggerPrefix-compiler:${Versions.dagger}"
        const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.dagger}"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"

        const val retrofit = "${retrofitPrefix}retrofit:${Versions.retrofit}"
        const val retrofitConverterGson = "${retrofitPrefix}converter-gson:${Versions.retrofit}"

        const val okHttp = "${okHttpPrefix}okhttp:${Versions.okHttp}"
        const val okHttpLoggingInterceptor = "${okHttpPrefix}logging-interceptor:${Versions.okHttp}"

        const val chucker = "com.github.chuckerteam.chucker:library:3.5.2"
        const val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:3.5.2"

        const val roomRuntime = "$roomPrefix-runtime:${Versions.room}"
        const val roomKapt = "$roomPrefix-compiler:${Versions.room}"
        const val roomKtx = "$roomPrefix-ktx:${Versions.room}"

        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
        const val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2"
        const val serializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0"

        const val gson = "com.google.code.gson:gson:${Versions.gson}"

        const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

        const val integrationLibrary = "com.github.evotor:integration-library:v0.6.19"


        object Versions {
            const val coroutinesCore = "1.6.2"
            const val lifecycle = "2.7.0"
            const val kotlinLifecycle = "2.5.1"
            const val androidxCore = "1.12.0"
            const val androidxAppCompat = "1.6.1"
            const val googleMaterial = "1.11.0"
            const val composeUi = "1.5.2"
            const val dagger = "2.46"
            const val retrofit = "2.9.0"
            const val okHttp = "4.10.0"
            const val room = "2.6.1"
            const val timber = "4.7.1"
            const val gson = "2.8.6"
            const val coil = "2.5.0"
            const val navigation = "2.7.5"
            const val hiltNavigation = "1.1.0"
            const val kotlinCollections = "0.3.6"
        }
    }

    private object Plugins {
        private const val kotlinPluginPrefix = "org.jetbrains.kotlin:kotlin-gradle-plugin:"
        private const val androidGradlePluginVersion = "8.1.3"

        const val kotlinPlugin = "$kotlinPluginPrefix${kotlinVersion}"
        const val androidGradlePlugin = "com.android.tools.build:gradle:$androidGradlePluginVersion"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Libraries.Versions.dagger}"
    }

}