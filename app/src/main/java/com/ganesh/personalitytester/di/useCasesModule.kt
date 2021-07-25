package com.ganesh.personalitytester.di


import com.ganesh.personalitytester.data.local.AnswerDao
import com.ganesh.personalitytester.data.usecase.question_list.PersonalityQuestionUsecase
import com.ganesh.personalitytester.data.remote.PersonalityQuestionService
import com.ganesh.personalitytester.data.usecase.question_list.PersonalityQuestionUsecaseImpl
import com.ganesh.personalitytester.data.usecase.save_answer.SaveAnswerUseCase
import com.ganesh.personalitytester.data.usecase.save_answer.SaveAnswerUseCaseImpl
import org.koin.dsl.module


val useCasesModule = module {
    single { provideListUseCase(get()) }
    single { provideSavaAnswerUseCase(get()) }
}

fun provideListUseCase(
    personalityQuestionService: PersonalityQuestionService

): PersonalityQuestionUsecase {
    return PersonalityQuestionUsecaseImpl(
        personalityQuestionService
    )
}

fun provideSavaAnswerUseCase(dao: AnswerDao): SaveAnswerUseCase {
    return SaveAnswerUseCaseImpl(dao)
}

