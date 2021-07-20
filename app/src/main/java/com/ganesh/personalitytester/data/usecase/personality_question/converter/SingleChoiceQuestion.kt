package com.ganesh.personalitytester.data.usecase.personality_question.converter

import com.ganesh.personalitytester.data.usecase.personality_question.QuestionsRemoteData
import com.ganesh.personalitytester.questionList.QuestionCategoryType
import com.ganesh.personalitytester.questionList.QuestionType
import com.ganesh.personalitytester.questionList.QuestionUIData
import com.ganesh.personalitytester.questionList.SingleChoiceQuestionUiData


class SingleChoiceQuestion(
    private val questionData: QuestionsRemoteData,
    private val categoryType: QuestionCategoryType
) :
    QuestionInterface {
    override fun convertUIQuestionData(): QuestionUIData =
        SingleChoiceQuestionUiData(
            questionData.question,
            QuestionType.SINGLE_CHOICE,
            categoryType,
            questionData.toOptions()
        )
}