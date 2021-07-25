package com.ganesh.personalitytester.di

import android.app.Application
import com.ganesh.personalitytester.data.local.AnswerDao
import com.ganesh.personalitytester.data.local.AnswerDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localDataSourceModule = module {
    single { provideDatabase(androidApplication()) }
    single { provideFavoritesDao(get()) }
}

internal fun provideFavoritesDao(db: AnswerDataBase): AnswerDao =
    db.answerDAO()


fun provideDatabase(application: Application): AnswerDataBase =
    AnswerDataBase.get(application)