package com.ganesh.personalitytester.data.usecase.personality_question

import com.ganesh.personalitytester.data.PersonalityQuestionUsecase
import com.ganesh.personalitytester.questionList.QuestionUIData
import com.ganesh.personalitytester.data.remote.PersonalityQuestionService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PersonalityQuestionUsecaseImpl(private val api: PersonalityQuestionService) :
    PersonalityQuestionUsecase {
    override suspend fun getQuestions(): Flow<List<QuestionUIData?>> = flow {
        emit(api.getQuestions().toUiData())
    }

}