package com.ganesh.personalitytester.data.usecase.question_list.converter

import com.ganesh.personalitytester.data.usecase.question_list.model.QuestionsRemoteData
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.questionList.model.QuestionType
import com.ganesh.personalitytester.questionList.model.QuestionType.*

class PersonalityQuestionFactory {
    companion object {
        fun build(
            questionData: QuestionsRemoteData,
            questionType: QuestionType,
        ): QuestionInterface {

            return when (questionType) {
                SINGLE_CHOICE -> {
                    SingleChoiceQuestion(questionData)
                }

                SINGLE_CHOICE_CONDITIONAL -> {
                    SingleChoiceConditionalQuestion(
                        questionData
                    )
                }
                NUMBER_RANGE -> NumberRangeQuestion(questionData.question_type.condition?.if_positive)
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