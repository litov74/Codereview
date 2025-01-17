package com.codereview.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "http://194.87.151.162:8000/"

    private val contentType = "application/json".toMediaType()
    private val json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    fun createOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val chuckerInterceptor = ChuckerInterceptor.Builder(context)
            .alwaysReadResponseBody(true)
            .build()

        return OkHttpClient.Builder()
            .addInterceptor(chuckerInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun retrofitInit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}