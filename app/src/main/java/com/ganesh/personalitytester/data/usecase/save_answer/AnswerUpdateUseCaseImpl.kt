package com.ganesh.personalitytester.data.usecase.save_answer

import com.ganesh.personalitytester.data.local.AnswerDao
import com.ganesh.personalitytester.data.local.AnswerEntity
import com.ganesh.personalitytester.data.usecase.toAnswerEntity
import com.ganesh.personalitytester.questionList.model.QuestionType
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.questionList.model.SingleChoiceConditionalQuestionUiData
import com.ganesh.personalitytester.questionList.model.SingleChoiceQuestionUiData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnswerUpdateUseCaseImpl(private val answerDao: AnswerDao) : AnswerUpdateUseCase {
    override suspend fun saveAnswer(questions: List<QuestionUIData?>?): Flow<Boolean> = flow {
        questions?.forEach {
            when (it?.questionType) {
                QuestionType.SINGLE_CHOICE -> {
                    saveAllTypeAnswer(
                        it.name,
                        it.categoryName ?: "",
                        saveSingleChoiceAnswer(it as SingleChoiceQuestionUiData)
                    )
                }

                QuestionType.SINGLE_CHOICE_CONDITIONAL -> {
                    saveAllTypeAnswer(
                        it.name,
                        it.categoryName ?: "",
                        saveSingleChoiceConditionalAnswer(it as SingleChoiceConditionalQuestionUiData)
                    )
                }

                else -> throw Exception("No data is saved")
            }
        }
        emit(true)
    }

    private suspend fun saveSingleChoiceAnswer(input: SingleChoiceQuestionUiData): Long =
        answerDao.insertSingleChoiceAnswer(input.toAnswerEntity())


    private suspend fun saveSingleChoiceConditionalAnswer(input: SingleChoiceConditionalQuestionUiData): Long =
        answerDao.insertSingleChoiceConditionalAnswer(input.toAnswerEntity())

    private suspend fun saveAllTypeAnswer(
        questionName: String,
        answerType: String,
        answerID: Long
    ): Long {
        val entity =
            AnswerEntity(
                questionName = questionName,
                answerType = answerType,
                answerID = answerID.toInt()
            )

        return answerDao.insertAnswerEntity(entity)
    }

}