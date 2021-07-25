package com.ganesh.personalitytester.data.usecase.question_list.converter

import com.ganesh.personalitytester.data.usecase.question_list.model.QuestionsRemoteData
import com.ganesh.personalitytester.questionList.model.QuestionType
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.questionList.model.SingleChoiceQuestionUiData
import java.util.*


class SingleChoiceQuestion(
    private val questionData: QuestionsRemoteData,
) :
    QuestionInterface {
    override fun convertUIQuestionData(): QuestionUIData =
        SingleChoiceQuestionUiData(
            questionData.question,
            QuestionType.SINGLE_CHOICE,
            options = questionData.toOptions(),
            canShowCategoryName = false,
            categoryName = questionData.category.replace("_", " ").toUpperCase(Locale.ROOT)
        )
}