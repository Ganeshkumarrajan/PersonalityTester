package com.ganesh.personalitytester.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T : Any> launchCoroutine(
        block: suspend CoroutineScope.() -> Unit,
        data: MutableLiveData<Result<T>>?
    ): Job {
        return viewModelScope.launch {
            try {
                data?.value = Result.Loading
                block()
                data?.value = Result.Success(null)
            } catch (e: Exception) {
                data?.value = Result.Error(e)
            }
        }
    }

}