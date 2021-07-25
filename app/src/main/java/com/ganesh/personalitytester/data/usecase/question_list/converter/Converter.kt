package com.ganesh.personalitytester.data.usecase.question_list.converter

import com.ganesh.personalitytester.data.usecase.question_list.model.PersonalityQuestionRemoteResult
import com.ganesh.personalitytester.questionList.model.QuestionType
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.utils.CommonUtils
import java.util.*
import kotlin.collections.HashMap

fun PersonalityQuestionRemoteResult.toUiData(): List<QuestionUIData?> {

    val questionsMap = HashMap<String, MutableList<QuestionUIData?>>()

    this.questions.forEachIndexed { _, question ->

        val questionType = CommonUtils.lookup(
            question.question_type.type.toUpperCase(Locale.ROOT),
            QuestionType.SINGLE_CHOICE
        ) ?: QuestionType.SINGLE_CHOICE

        val questionBuilder: QuestionInterface =
            PersonalityQuestionFactory.build(question, questionType)

        addItemIntoQuestionHashMap(questionsMap, questionBuilder.convertUIQuestionData())
    }

    return sortQuestionsBasedOnCategory(questionsMap)
}

private fun addItemIntoQuestionHashMap(
    questionsMap: HashMap<String, MutableList<QuestionUIData?>>,
    result: QuestionUIData
) {
    val list = questionsMap[result.categoryName]

    if (list == null) {
        val tempList = mutableListOf<QuestionUIData?>()
        result.canShowCategoryName = true
        tempList.add(result)
        questionsMap[result.categoryName ?: ""] = tempList
    } else {
        list.add(result)
    }
}


private fun sortQuestionsBasedOnCategory(mapData: HashMap<String, MutableList<QuestionUIData?>>): List<QuestionUIData?> {
    val questionList = mutableListOf<QuestionUIData?>()

    for ((_, value) in mapData) {
        questionList.addAll(value)
    }

    return questionList
}