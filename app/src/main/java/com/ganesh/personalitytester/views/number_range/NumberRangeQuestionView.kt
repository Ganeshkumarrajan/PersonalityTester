package com.ganesh.personalitytester.views.number_range

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.ganesh.personalitytester.databinding.NumberRangeLayoutBinding
import com.ganesh.personalitytester.questionList.model.NumberRangeDataUiData
import com.ganesh.personalitytester.views.BaseQuestionView

class NumberRangeQuestionView : BaseQuestionView<Int, NumberRangeDataUiData> {

    private val binding: NumberRangeLayoutBinding =
        NumberRangeLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int) : super(
        context,
        attributes,
        styleAttr
    )

    override fun setQuestion(question: NumberRangeDataUiData?) {
        binding.questionData = question
    }

}


