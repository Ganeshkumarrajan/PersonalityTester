package com.ganesh.personalitytester.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:viewVisibility")
fun viewVisibility(view: View, canBeShown: Boolean) {
    if (canBeShown) view.visibility = View.VISIBLE
    else view.visibility = View.GONE
}