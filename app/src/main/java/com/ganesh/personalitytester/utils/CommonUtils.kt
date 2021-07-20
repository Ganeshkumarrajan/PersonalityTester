package com.ganesh.personalitytester.utils

import java.util.*


class CommonUtils {

    companion object {
        inline fun <reified E : Enum<E>> lookup(id: String?, default: E? = null): E? {
            return try {
                if (id == null) null
                else enumValueOf<E>(id.toUpperCase(Locale.ROOT))
            } catch (e: Throwable) {
                default
            }
        }
    }
}