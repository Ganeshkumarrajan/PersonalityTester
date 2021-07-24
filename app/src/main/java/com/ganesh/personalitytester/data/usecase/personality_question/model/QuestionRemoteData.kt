package com.ganesh.personalitytester.data.usecase.personality_question.model

data class QuestionsRemoteData(
    val question: String,
    val category: String,
    val question_type: QuestionType
)

data class QuestionType(
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



