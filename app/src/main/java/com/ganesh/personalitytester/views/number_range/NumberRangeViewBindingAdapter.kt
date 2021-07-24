package com.ganesh.personalitytester.views.number_range

import android.widget.NumberPicker
import androidx.databinding.BindingAdapter
import com.ganesh.personalitytester.questionList.NumberRangeLimit


@BindingAdapter("app:ranges")
fun setRangeToPicker(numberPicker: NumberPicker, numberRangeLimit: NumberRangeLimit?) {
    numberRangeLimit?.let {
        numberPicker.minValue = it.from.toInt()
        numberPicker.maxValue = it.to.toInt()
    }
}


