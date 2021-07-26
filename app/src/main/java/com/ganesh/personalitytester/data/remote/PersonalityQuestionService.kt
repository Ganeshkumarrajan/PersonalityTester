package com.ganesh.personalitytester.data.remote

import com.ganesh.personalitytester.data.usecase.question_list.model.PersonalityQuestionRemoteResult
import retrofit2.http.GET

interface PersonalityQuestionService {
    @GET("coding_exercises_options/master/personality_test/database/personality_test.json")
    suspend fun getQuestions(): PersonalityQuestionRemoteResult
}