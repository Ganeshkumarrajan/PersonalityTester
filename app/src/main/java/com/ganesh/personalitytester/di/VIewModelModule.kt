package com.ganesh.personalitytester.di

import com.ganesh.personalitytester.questionList.viewmodel.QuestionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        QuestionsViewModel(
            get(),get()
        )
    }

}