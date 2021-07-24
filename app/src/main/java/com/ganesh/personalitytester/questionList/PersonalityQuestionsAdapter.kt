package com.ganesh.personalitytester.questionList

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PersonalityQuestionAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val questions = mutableListOf<QuestionUIData?>()


    override fun getItemViewType(position: Int): Int {
        val item = questions[position]

        return when (item?.questionType) {
            QuestionType.SINGLE_CHOICE -> QuestionType.SINGLE_CHOICE.ordinal
            QuestionType.SINGLE_CHOICE_CONDITIONAL -> QuestionType.SINGLE_CHOICE_CONDITIONAL.ordinal
            else -> QuestionType.SINGLE_CHOICE.ordinal
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return when (viewType) {
            QuestionType.SINGLE_CHOICE.ordinal -> SingleChoiceQuestionViewHolder(parent)
            QuestionType.SINGLE_CHOICE_CONDITIONAL.ordinal -> SingleChoiceConditionalQuestionViewHolder(
                parent
            )
            else -> SingleChoiceQuestionViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        questions[position]?.let {
            when (holder) {
                is SingleChoiceQuestionViewHolder -> {
                    holder.bind(it as SingleChoiceQuestionUiData)
                }
                is SingleChoiceConditionalQuestionViewHolder -> {
                    holder.bind(it as SingleChoiceConditionalQuestionUiData)
                }

            }
        }
    }


    override fun getItemCount(): Int = questions.size


    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<QuestionUIData?>) {
        questions.clear()
        questions.addAll(data)
        notifyDataSetChanged()
    }

}








