package com.ganesh.personalitytester.questionList.view

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ganesh.personalitytester.base.Result


@BindingAdapter("app:progressbarVisibility")
fun setProgressBarVisibility(view: ProgressBar, state: Result<Boolean>?) {
    state?.let {
        if (state is Result.Loading) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}

@BindingAdapter("app:showError")
fun showError(view: TextView, state: Result<Boolean>?) {
    state?.let {
        if (state is Result.Error) {
            view.visibility = View.VISIBLE
            view.text = state.exception.localizedMessage
        } else {
            view.visibility = View.GONE
        }
    }
}

