package com.ganesh.personalitytester.views.singel_conice_conditional

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.ganesh.personalitytester.databinding.SingleChoiceQuestionBinding
import com.ganesh.personalitytester.databinding.SingleChoiceWithConditionalQuestionBinding
import com.ganesh.personalitytester.questionList.SingleChoiceConditionalQuestionUiData
import com.ganesh.personalitytester.questionList.SingleChoiceQuestionUiData
import com.ganesh.personalitytester.views.BaseQuestionView
import com.ganesh.personalitytester.views.single_choice.AnswerSelectionListener
import com.ganesh.personalitytester.views.single_choice.SingleChoiceQuestionAdapter

class SingleChoiceWithConditionalQuestionView :
    BaseQuestionView<String, SingleChoiceConditionalQuestionUiData>,
    AnswerSelectionListener {

    private var question: SingleChoiceConditionalQuestionUiData? = null
    val adapter = SingleChoiceQuestionAdapter()

    private val binding: SingleChoiceWithConditionalQuestionBinding =
        SingleChoiceWithConditionalQuestionBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int) : super(
        context,
        attributes,
        styleAttr
    )

    override fun onAnswerSelected(answer: String) {
        onAnsweredBlock?.invoke(answer)
    }

    override fun setQuestion(question: SingleChoiceConditionalQuestionUiData?) {
        this.question = question
        binding.questionData = question
        binding.singleChoiceView.setQuestion(question)
        binding.singleChoiceView.registerToAnswerCompletion {
            if (canShowRangeView(it)) binding.numberRangeView.setQuestion(this.question?.subQuestionData)
            else binding.numberRangeView.setQuestion(null)
        }
    }

    private fun canShowRangeView(selectedAnswer: String): Boolean {
        question?.conditions?.forEach {
            if (it == selectedAnswer) {
                return true
            }
        }
        return false
    }

}


