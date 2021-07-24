package com.ganesh.personalitytester.questionList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ganesh.personalitytester.databinding.SingelChonceViewAdpaterLayoutBinding
import com.ganesh.personalitytester.databinding.SingelChonceWithConditionalViewAdpaterLayoutBinding

class SingleChoiceConditionalQuestionViewHolder(val binding: SingelChonceWithConditionalViewAdpaterLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        SingelChonceWithConditionalViewAdpaterLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


     fun bind(data: SingleChoiceConditionalQuestionUiData) {
        binding.view.setQuestion(data)
    }


}


class SingleChoiceQuestionViewHolder(private val binding: SingelChonceViewAdpaterLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        SingelChonceViewAdpaterLayoutBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
    )

     fun bind(data: SingleChoiceQuestionUiData) {
        binding.view.setQuestion(data)
    }

}


/*abstract class QuestionTypeViewHolder<QD : Any>(vb: View) :
    RecyclerView.ViewHolder(vb) {
    abstract fun bind(data: QD)
*/