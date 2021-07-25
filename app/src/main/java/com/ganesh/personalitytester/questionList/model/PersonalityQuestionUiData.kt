package com.ganesh.personalitytester.questionList.model

enum class QuestionType(val typeName: String) {
    SINGLE_CHOICE("single_choice"),
    SINGLE_CHOICE_CONDITIONAL("single_choice_conditional"),
    NUMBER_RANGE("number_range")
}

abstract class QuestionUIData(
    open val name: String,
    open val questionType: QuestionType,
    open var answer: Answer? = null,
    open var canShowCategoryName: Boolean? = false,
    open var categoryName: String? = ""
)

open class SingleChoiceQuestionUiData(
    override val name: String,
    override val questionType: QuestionType,
    override var canShowCategoryName: Boolean?,
    override var categoryName: String?,
    open val options: List<String>
) : QuestionUIData(
    name,
    questionType
)


data class SingleChoiceConditionalQuestionUiData(
    override val name: String,
    override val questionType: QuestionType,
    override var canShowCategoryName: Boolean?,
    override var categoryName: String?,
    override val options: List<String>,
    val conditions: List<String>?,
    val subQuestionData: NumberRangeDataUiData
) : SingleChoiceQuestionUiData(
    name,
    questionType,canShowCategoryName=canShowCategoryName,categoryName=categoryName,options = options)

data class NumberRangeDataUiData(
    override val name: String,
    override val questionType: QuestionType,
    val range: NumberRangeLimit
) : QuestionUIData(name, questionType)

data class NumberRangeLimit(val from: Long, val to: Long)


data class Answer(val answer: String?, val conditionAnswer: String? = null)