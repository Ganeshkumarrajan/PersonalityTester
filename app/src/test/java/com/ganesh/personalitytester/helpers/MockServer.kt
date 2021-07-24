package com.ganesh.personalitytester.helpers

import com.ganesh.personalitytester.data.remote.PersonalityQuestionService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

open class MockServerBaseTestInterfaceImpl : MockServerBaseTestInterface {

    private lateinit var mockWebServer: MockWebServer

    override lateinit var personalityQuestionsApiService: PersonalityQuestionService

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var loggingInterceptor: HttpLoggingInterceptor

    override fun setupMockServer() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = QuestionsRequestDispatcher()
        mockWebServer.start()
        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClient = buildOkhttpClient(loggingInterceptor)

        personalityQuestionsApiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(PersonalityQuestionService::class.java)
    }

    override fun closeMockServer() {
        mockWebServer.shutdown()
    }

    private fun buildOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

}


interface MockServerBaseTestInterface {
    var personalityQuestionsApiService: PersonalityQuestionService
    fun setupMockServer()
    fun closeMockServer()
}
