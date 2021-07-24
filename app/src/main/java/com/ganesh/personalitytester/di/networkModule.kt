package com.ganesh.personalitytester.di

import com.ganesh.personalitytester.data.remote.PersonalityQuestionService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {

    single { providePersonalityQuestionService(retrofit = get()) }

    single {
        provideRetrofit(
            okHttpClient = get(),
            url = "https://raw.githubusercontent.com/sparknetworks/"
        )
    }

    single { provideOkHttpClient() }
}

internal fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

internal fun provideRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

internal fun providePersonalityQuestionService(retrofit: Retrofit): PersonalityQuestionService =
    retrofit.create(PersonalityQuestionService::class.java)
