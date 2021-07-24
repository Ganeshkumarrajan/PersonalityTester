package com.ganesh.personalitytester.views.single_choice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ganesh.personalitytester.databinding.SingelChonceQuestionAdpaterLayoutBinding


class SingleChoiceQuestionAdapter : RecyclerView.Adapter<SingleChoiceQuestionAdapterViewHolder>() {

    private var choiceAnswers = mutableListOf<String>()
    private var listener: AnswerSelectionListener? = null
    private var selectedAnswer: String? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SingleChoiceQuestionAdapterViewHolder =
        SingleChoiceQuestionAdapterViewHolder(
            SingelChonceQuestionAdpaterLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SingleChoiceQuestionAdapterViewHolder, position: Int) =
        holder.bind(choiceAnswers[position], listener, selectedAnswer)

    override fun getItemCount(): Int = choiceAnswers.size

    fun setData(list: List<String>) {
        choiceAnswers.clear()
        choiceAnswers.addAll(list)
        notifyDataSetChanged()
    }

    fun setClickListener(listener: AnswerSelectionListener) {
        this.listener = listener
    }

    fun updateSelectedAnswer(answer: String) {
        this.selectedAnswer = answer
        notifyDataSetChanged()
    }
}

class SingleChoiceQuestionAdapterViewHolder(private val binding: SingelChonceQuestionAdpaterLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String, listener: AnswerSelectionListener?, selectedAnswer: String?) {
        binding.choiceAnswer = data
        binding.answerSelectionListener = listener
        binding.answerRadioButton.isChecked = selectedAnswer.equals(data)
    }

}