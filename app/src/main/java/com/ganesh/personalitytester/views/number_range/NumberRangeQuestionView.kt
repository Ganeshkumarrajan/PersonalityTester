package com.ganesh.personalitytester.views.number_range

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.ganesh.personalitytester.databinding.NumberRangeLayoutBinding
import com.ganesh.personalitytester.questionList.model.Answer
import com.ganesh.personalitytester.questionList.model.NumberRangeDataUiData
import com.ganesh.personalitytester.views.BaseQuestionView


class NumberRangeQuestionView : BaseQuestionView<Int, NumberRangeDataUiData> {
    var questionData: NumberRangeDataUiData? = null
    private val binding: NumberRangeLayoutBinding =
        NumberRangeLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int) : super(
        context,
        attributes,
        styleAttr
    )

    init {
        binding.numberRange.setOnValueChangedListener { _, _, newVal ->
            onAnsweredBlock?.invoke(newVal)
            questionData?.answer = Answer(newVal.toString())
        }
    }

    override fun setQuestion(question: NumberRangeDataUiData?) {
        this.questionData = question
        binding.questionData = question
    }

}


