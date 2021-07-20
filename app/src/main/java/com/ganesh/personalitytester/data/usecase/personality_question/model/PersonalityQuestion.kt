package com.ganesh.personalitytester.data.usecase.personality_question

import com.ganesh.personalitytester.questionList.QuestionUIData
import com.ganesh.personalitytester.questionList.QuestionCategoryType
import com.ganesh.personalitytester.questionList.QuestionType
import com.ganesh.personalitytester.data.usecase.personality_question.converter.PersonalityQuestionFactory
import com.ganesh.personalitytester.data.usecase.personality_question.converter.QuestionInterface
import com.ganesh.personalitytester.utils.CommonUtils
import java.util.*

data class QuestionsRemoteData(
    val question: String,
    val category: String,
    val question_type: Question_type
)

data class Question_type(
    val type: String,
    val options: List<String>,
    val condition: Condition? = null,
)

data class Condition(
    val predicate: Predicate,
    val if_positive: IfPositive
)

data class IfPositive(
    val question: String,
    val category: String,
    val question_type: IfPositiveQuestionType
)

data class Predicate(
    val exactEquals: List<String>
)

data class IfPositiveQuestionType(
    val type: String,
    val range: Range
)

data class Range(
    val from: Long,
    val to: Long
)


data class PersonalityQuestionRemoteResult(
    val categories: List<String>,
    val questions: List<QuestionsRemoteData>
)


fun PersonalityQuestionRemoteResult.toUiData(): List<QuestionUIData?> {

    val questionList = mutableListOf<QuestionUIData?>()

    this.questions.forEachIndexed { _, question ->

        val questionCategoryType = CommonUtils.lookup(
            question.category.toUpperCase(Locale.ROOT),
            QuestionCategoryType.LIFESTYLE
        ) ?: QuestionCategoryType.LIFESTYLE

        val questionType = CommonUtils.lookup(
            question.question_type.type.toUpperCase(Locale.ROOT),
            QuestionType.SINGLE_CHOICE
        ) ?: QuestionType.SINGLE_CHOICE

        val questionBuilder: QuestionInterface =
            PersonalityQuestionFactory.build(question, questionCategoryType, questionType)

        questionList.add(questionBuilder.convertUIQuestionData())
    }

    return questionList
}