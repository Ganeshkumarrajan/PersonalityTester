package com.ganesh.personalitytester.questionList.view

import android.os.Bundle
import android.view.View
import com.ganesh.personalitytester.R
import com.ganesh.personalitytester.base.BaseFragment
import com.ganesh.personalitytester.databinding.QuestionListFragmentBinding
import com.ganesh.personalitytester.questionList.adapter.PersonalityQuestionAdapter
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.questionList.viewmodel.QuestionsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuestionListFragment : BaseFragment<QuestionListFragmentBinding>() {

    private val viewModel by viewModel<QuestionsViewModel>()
    private val adapter = PersonalityQuestionAdapter()

    override fun getLayout(): Int = R.layout.question_list_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataToRecyclerView()
        setViewModelObservers()
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setViewModelObservers() {
        viewModel.questions.observe(viewLifecycleOwner, {
            parseQuestionResult(it)
        })

        viewModel.answerSaving.observe(viewLifecycleOwner,{
            onSaved()
        })
    }

    private fun setDataToRecyclerView() {
        binding.question.adapter = adapter
    }

    private fun parseQuestionResult(result: List<QuestionUIData?>) {
        onQuestionsReceived(result)
    }

    private fun onQuestionsReceived(data: List<QuestionUIData?>) {
        adapter.setData(data)
    }

    private fun onSaved(){
        adapter.notifyDataSetChanged()
    }
}


