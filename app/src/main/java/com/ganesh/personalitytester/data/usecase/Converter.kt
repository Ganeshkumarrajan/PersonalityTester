package com.ganesh.personalitytester.data.usecase

import com.ganesh.personalitytester.data.local.SingleChoiceAnswerEntity
import com.ganesh.personalitytester.data.local.SingleChoiceConditionalAnswerEntity
import com.ganesh.personalitytester.questionList.model.SingleChoiceConditionalQuestionUiData
import com.ganesh.personalitytester.questionList.model.SingleChoiceQuestionUiData


fun SingleChoiceQuestionUiData.toAnswerEntity(): SingleChoiceAnswerEntity {
    return SingleChoiceAnswerEntity(questionName = this.name, answer = this.answer?.answer ?: "")
}

fun SingleChoiceConditionalQuestionUiData.toAnswerEntity(): SingleChoiceConditionalAnswerEntity =
    SingleChoiceConditionalAnswerEntity(
        questionName = this.name,
        answer = this.answer?.answer ?: "",
        condition = this.answer?.conditionAnswer ?: "",
        range = this.subQuestionData.answer?.answer ?: ""
    )