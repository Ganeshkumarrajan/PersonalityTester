package com.ganesh.personalitytester.di


import com.ganesh.personalitytester.data.usecase.personality_question.PersonalityQuestionUsecase
import com.ganesh.personalitytester.data.remote.PersonalityQuestionService
import com.ganesh.personalitytester.data.usecase.personality_question.PersonalityQuestionUsecaseImpl
import org.koin.dsl.module


val useCasesModule = module {
    single { provideListUseCase(get()) }

}

fun provideListUseCase(
    personalityQuestionService: PersonalityQuestionService

): PersonalityQuestionUsecase {
    return PersonalityQuestionUsecaseImpl(
        personalityQuestionService
    )
}

