package com.ganesh.personalitytester.data.usecase.save_answer

import com.ganesh.personalitytester.questionList.model.QuestionUIData
import kotlinx.coroutines.flow.Flow


interface SaveAnswerUseCase {
   suspend fun saveAnswer(questions: List<QuestionUIData?>?): Flow<Boolean>
}