package com.ganesh.personalitytester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.ganesh.personalitytester.base.Result
import com.ganesh.personalitytester.questionList.PersonalityQuestionAdapter
import com.ganesh.personalitytester.questionList.QuestionsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<QuestionsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.questions.observe(this, Observer {
            val adapter = PersonalityQuestionAdapter()
            answers.adapter = adapter
            when (it) {
                is Result.Success -> {
                    it.data?.let {
                        adapter.setData(it)
                    }

                }
            }

        })

        viewModel.getAllQuestions()
    }


}