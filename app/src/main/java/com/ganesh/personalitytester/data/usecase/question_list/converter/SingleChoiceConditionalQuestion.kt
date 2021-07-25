package com.ganesh.personalitytester.data.usecase.question_list.converter

import com.ganesh.personalitytester.data.usecase.question_list.model.QuestionsRemoteData

import com.ganesh.personalitytester.questionList.model.NumberRangeDataUiData
import com.ganesh.personalitytester.questionList.model.QuestionType
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.questionList.model.SingleChoiceConditionalQuestionUiData
import java.util.*


class SingleChoiceConditionalQuestion(
    private val questionData: QuestionsRemoteData,
) : QuestionInterface {
    override fun convertUIQuestionData(): QuestionUIData {
        val exactEquals = mutableListOf<String>()

        questionData.question_type.condition?.predicate?.exactEquals?.forEach {
            exactEquals.add(it)
        }

        val rangeQuestion: NumberRangeDataUiData =
            PersonalityQuestionFactory.build(questionData, QuestionType.NUMBER_RANGE)
                .convertUIQuestionData() as NumberRangeDataUiData

        return SingleChoiceConditionalQuestionUiData(
            questionData.question,
            QuestionType.SINGLE_CHOICE_CONDITIONAL,
            options = questionData.toOptions(),
            conditions = exactEquals,
            subQuestionData = rangeQuestion,
            canShowCategoryName = false,
            categoryName = questionData.category.replace("_", " ").toUpperCase(Locale.ROOT)
        )
    }
}
