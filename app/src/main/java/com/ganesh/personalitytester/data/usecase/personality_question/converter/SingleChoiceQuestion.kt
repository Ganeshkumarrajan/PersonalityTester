package com.ganesh.personalitytester.data.usecase.personality_question.converter

import com.ganesh.personalitytester.data.usecase.personality_question.model.QuestionsRemoteData
import com.ganesh.personalitytester.questionList.QuestionType
import com.ganesh.personalitytester.questionList.QuestionUIData
import com.ganesh.personalitytester.questionList.SingleChoiceQuestionUiData
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