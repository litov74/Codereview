package com.codereview.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
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
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private val json: Json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    isLenient = true
}

private const val BASE_URL = "https://jobs.yourcodereview.com/api/"

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    companion object {
        @Singleton
        @Provides
        fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        @Singleton
        @Provides
        fun provideOkHttpClient(
            @ApplicationContext context: Context,
            httpLoggingInterceptor: HttpLoggingInterceptor,
        ): OkHttpClient =
            UnsafeOkHttpClient
                .getUnsafeOkHttpClient()
                .newBuilder()
                .connectTimeout(1, TimeUnit.DAYS)
                .readTimeout(1, TimeUnit.DAYS)
                .writeTimeout(1, TimeUnit.DAYS)
                .retryOnConnectionFailure(false)
                .callTimeout(1, TimeUnit.DAYS)
                .hostnameVerifier({ hostname, session -> true })
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(
                    ChuckerInterceptor.Builder(context)
                        .collector(ChuckerCollector(context))
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                )
                .build()


        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .addConverterFactory(
                json.asConverterFactory(contentType = "application/json".toMediaType())
            )
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

        @Singleton
        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)
    }
}