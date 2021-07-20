package com.ganesh.personalitytester.data

import com.ganesh.personalitytester.questionList.QuestionUIData
import kotlinx.coroutines.flow.Flow


interface PersonalityQuestionUsecase {
    suspend fun getQuestions(): Flow<List<QuestionUIData?>>
}


