package com.ganesh.personalitytester.utils

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:adapter")
fun <T> assignAdapter(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?
) {
    adapter?.let {
        recyclerView.adapter = adapter
    }
}

@BindingAdapter("app:viewVisibility")
fun viewVisibility(view: View, canBeShown: Boolean) {
    if (canBeShown) view.visibility = View.VISIBLE
    else view.visibility = View.GONE
}