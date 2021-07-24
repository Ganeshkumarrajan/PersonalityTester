package com.ganesh.personalitytester

import android.app.Application
import com.ganesh.personalitytester.di.networkModule
import com.ganesh.personalitytester.di.useCasesModule
import com.ganesh.personalitytester.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PersonalityTesterApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PersonalityTesterApp)
            modules(
                networkModule,

                useCasesModule,

                viewModelsModule,
            )
        }
    }
}