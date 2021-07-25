package com.ganesh.personalitytester.views.singel_conice_conditional

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.ganesh.personalitytester.databinding.SingleChoiceWithConditionalQuestionBinding
import com.ganesh.personalitytester.questionList.model.SingleChoiceConditionalQuestionUiData
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

    init {
        registerForAnswering()
    }

    override fun onAnswerSelected(answer: String) {
        onAnsweredBlock?.invoke(answer)
    }

    override fun setQuestion(question: SingleChoiceConditionalQuestionUiData?) {
        this.question = question
        binding.singleChoiceView.setQuestion(question)
    }

    private fun registerForAnswering() {
        binding.singleChoiceView.registerToAnswerCompletion {
            onAnsweredOnSingleChoiceQuestionView(it)
        }

        binding.numberRangeView.registerToAnswerCompletion {

        }
    }

    private fun onAnsweredOnSingleChoiceQuestionView(answer: String) {
        if (canShowNumberRangeQuestionView(answer)) showNumberRangeQuestionTypeView()
        else hideNumberRangeQuestionView()
    }

    private fun onAnsweredOnNumberRangeQuestionView(answer:Int){

    }

    private fun showNumberRangeQuestionTypeView() {
        binding.numberRangeViewVisibility = true
        binding.numberRangeView.setQuestion(this.question?.subQuestionData)
    }

    private fun hideNumberRangeQuestionView() {
        binding.numberRangeViewVisibility = false
        binding.numberRangeView.setQuestion(null)
    }

    private fun canShowNumberRangeQuestionView(selectedAnswer: String): Boolean {
        question?.conditions?.forEach {
            if (it == selectedAnswer) {
                return true
            }
        }
        return false
    }

}


