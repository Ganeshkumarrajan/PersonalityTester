package com.ganesh.personalitytester.questionList


enum class QuestionCategoryType(val categoryName: String) {
    HARD_FACT("hard_fact"),
    LIFESTYLE("lifestyle"),
    INTROVERSION("introversion"),
    PASSION("passion")
}

enum class QuestionType(val typeName: String) {
    SINGLE_CHOICE("single_choice"),
    SINGLE_CHOICE_CONDITIONAL("single_choice_conditional"),
    NUMBER_RANGE("number_range")
}

abstract class QuestionUIData(
    open val name: String,
    open val questionType: QuestionType
)

data class SingleChoiceQuestionUiData(
    override val name: String,
    override val questionType: QuestionType,
    val categoryType: QuestionCategoryType,
    val options: List<String>
) : QuestionUIData(name, questionType)


data class SingleChoiceConditionalQuestionUiData(
    override val name: String,
    override val questionType: QuestionType,
    val categoryType: QuestionCategoryType,
    val options: List<String>,
    val conditions: List<String>?,
    val subQuestionData: NumberRangeDataUiData
) : QuestionUIData(name, questionType)

data class NumberRangeDataUiData(
    override val name: String,
    override val questionType: QuestionType,
    val categoryType: QuestionCategoryType,
    val range: NumberRangeLimit
) : QuestionUIData(name, questionType)

data class NumberRangeLimit(val from: Long, val to: Long)