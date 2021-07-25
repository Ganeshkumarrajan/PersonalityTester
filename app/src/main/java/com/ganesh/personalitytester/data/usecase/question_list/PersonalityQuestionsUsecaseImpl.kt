package com.ganesh.personalitytester.data.usecase.question_list

import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.data.remote.PersonalityQuestionService
import com.ganesh.personalitytester.data.usecase.question_list.converter.toUiData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PersonalityQuestionUsecaseImpl(private val api: PersonalityQuestionService) :
    PersonalityQuestionUsecase {
    override suspend fun getQuestions(): Flow<List<QuestionUIData?>> = flow {
        emit(api.getQuestions().toUiData())
    }

}