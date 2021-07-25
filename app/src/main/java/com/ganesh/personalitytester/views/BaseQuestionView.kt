package com.ganesh.personalitytester.views


import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.ganesh.personalitytester.questionList.model.QuestionUIData

abstract class BaseQuestionView<A,QD : QuestionUIData> : ConstraintLayout {

    var onAnsweredBlock: ((A) -> Unit?)? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
    constructor(context: Context, attributes: AttributeSet, styleAttr: Int) : super(
        context,
        attributes,
        styleAttr
    )

    fun registerToAnswerCompletion(onAnsweredBlock: ((A) -> Unit?)?) {
        this.onAnsweredBlock = onAnsweredBlock
    }

    abstract fun setQuestion(question: QD?)

}