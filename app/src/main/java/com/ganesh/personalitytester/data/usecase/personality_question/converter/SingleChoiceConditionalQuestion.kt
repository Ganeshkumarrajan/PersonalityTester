package com.ganesh.personalitytester.data.usecase.personality_question.converter

import com.ganesh.personalitytester.data.usecase.personality_question.QuestionsRemoteData

import com.ganesh.personalitytester.questionList.*


class SingleChoiceConditionalQuestion(
    private val questionData: QuestionsRemoteData,
    private val categoryType: QuestionCategoryType
) : QuestionInterface {
    override fun convertUIQuestionData(): QuestionUIData {
        val exactEquals = mutableListOf<String>()

        questionData.question_type.condition?.predicate?.exactEquals?.forEach {
            exactEquals.add(it)
        }

        val rangeQuestion: NumberRangeDataUiData =
            PersonalityQuestionFactory.build(questionData, categoryType, QuestionType.NUMBER_RANGE).convertUIQuestionData() as NumberRangeDataUiData

        return SingleChoiceConditionalQuestionUiData(
            questionData.question,
            QuestionType.SINGLE_CHOICE_CONDITIONAL,
            categoryType,
            questionData.toOptions(),
            conditions = exactEquals,
            subQuestionData = rangeQuestion
        )
    }
}
