package com.ganesh.personalitytester.data.usecase.question_list

import com.ganesh.personalitytester.questionList.model.QuestionUIData
import kotlinx.coroutines.flow.Flow


interface PersonalityQuestionUsecase {
    suspend fun getQuestions(): Flow<List<QuestionUIData?>>
}


