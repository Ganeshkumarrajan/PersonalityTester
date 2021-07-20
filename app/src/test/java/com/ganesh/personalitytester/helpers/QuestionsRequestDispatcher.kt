package com.ganesh.personalitytester.helpers

import com.ganesh.personalitytester.helpers.Constants.VALID_PERSONALITY_QUESTIONS_URL
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection


internal class QuestionsRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            VALID_PERSONALITY_QUESTIONS_URL -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("json/questions.json"))
            }
            else -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("json/questions.json"))
            }
        }
    }

}