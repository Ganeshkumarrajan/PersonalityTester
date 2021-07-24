package com.ganesh.personalitytester.views.single_choice

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.ganesh.personalitytester.databinding.SingleChoiceQuestionBinding
import com.ganesh.personalitytester.questionList.Answer
import com.ganesh.personalitytester.questionList.SingleChoiceQuestionUiData
import com.ganesh.personalitytester.views.BaseQuestionView

class SingleChoiceQuestionView : BaseQuestionView<String, SingleChoiceQuestionUiData>,
    AnswerSelectionListener {

    private var question: SingleChoiceQuestionUiData? = null
    val adapter = SingleChoiceQuestionAdapter()

    private val binding: SingleChoiceQuestionBinding =
        SingleChoiceQuestionBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int) : super(
        context,
        attributes,
        styleAttr
    )

    override fun setQuestion(question: SingleChoiceQuestionUiData?) {
        this.question = question
        setDataToAllViews(question)
    }

    private fun setDataToAllViews(question: SingleChoiceQuestionUiData?) {
        adapter.setClickListener(this)
        binding.answers.adapter = adapter
        binding.questionData = question
        adapter.setData(question?.options ?: emptyList())
    }

    override fun onAnswerSelected(answer: String) {
        question?.answer = Answer(answer)
        adapter.updateSelectedAnswer(answer)
        onAnsweredBlock?.invoke(answer)
    }
}

interface AnswerSelectionListener {
    fun onAnswerSelected(answer: String)
}

