package com.ganesh.personalitytester.data.usecase.personality_question.converter

import com.ganesh.personalitytester.data.usecase.personality_question.model.IfPositive
import com.ganesh.personalitytester.questionList.NumberRangeDataUiData
import com.ganesh.personalitytester.questionList.NumberRangeLimit
import com.ganesh.personalitytester.questionList.QuestionType


class NumberRangeQuestion(
    private val questionData: IfPositive?
) :
    QuestionInterface {
    override fun convertUIQuestionData(): NumberRangeDataUiData =
        NumberRangeDataUiData(
            questionData?.question ?: "",
            QuestionType.NUMBER_RANGE,
            NumberRangeLimit(
                questionData?.question_type?.range?.from ?: 0,
                questionData?.question_type?.range?.to ?: 0
            )
        )
}