package com.ganesh.personalitytester.data.usecase.personality_question.converter

import com.ganesh.personalitytester.data.usecase.personality_question.model.QuestionsRemoteData

import com.ganesh.personalitytester.questionList.*
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
