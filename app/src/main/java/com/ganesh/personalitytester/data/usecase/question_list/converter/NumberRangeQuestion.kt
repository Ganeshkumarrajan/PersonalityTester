package com.ganesh.personalitytester.data.usecase.question_list.converter

import com.ganesh.personalitytester.data.usecase.question_list.model.IfPositive
import com.ganesh.personalitytester.questionList.model.NumberRangeDataUiData
import com.ganesh.personalitytester.questionList.model.NumberRangeLimit
import com.ganesh.personalitytester.questionList.model.QuestionType


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