package com.ganesh.personalitytester.data.usecase.personality_question.converter

import com.ganesh.personalitytester.data.usecase.personality_question.QuestionsRemoteData
import com.ganesh.personalitytester.questionList.QuestionUIData
import com.ganesh.personalitytester.questionList.QuestionCategoryType
import com.ganesh.personalitytester.questionList.QuestionType
import com.ganesh.personalitytester.questionList.QuestionType.*

class PersonalityQuestionFactory {
    companion object {
        fun build(
            questionData: QuestionsRemoteData,
            categoryType: QuestionCategoryType,
            questionType: QuestionType,
            ): QuestionInterface {

            return when (questionType) {
                SINGLE_CHOICE -> {
                    SingleChoiceQuestion(questionData, categoryType)
                }

                SINGLE_CHOICE_CONDITIONAL -> {
                    SingleChoiceConditionalQuestion(
                        questionData, categoryType
                    )
                }
                NUMBER_RANGE -> NumberRangeQuestion(questionData.question_type.condition?.if_positive, categoryType)
            }
        }
    }
}


interface QuestionInterface {
    fun convertUIQuestionData(): QuestionUIData
}


fun QuestionsRemoteData.toOptions(): List<String> {
    val options = mutableListOf<String>()
    this.question_type.options.forEach {
        options.add(it)
    }

    return options
}