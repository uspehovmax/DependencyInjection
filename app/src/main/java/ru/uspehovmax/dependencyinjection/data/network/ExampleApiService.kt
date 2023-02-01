package ru.uspehovmax.dependencyinjection.data.network

import android.content.Context
import android.util.Log
import ru.uspehovmax.dependencyinjection.R
import ru.uspehovmax.dependencyinjection.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Singleton

//@ApplicationScope // убрали
class ExampleApiService @Inject constructor(
    private val context: Context,
    private val timeMillis: Long
) {

    companion object {
        private const val LOG_MSG = "MSG"
        private const val message = "ExampleApiService: "
    }

    fun method() {
        Log.d(LOG_MSG, "$this - $message - ${context.getString(R.string.app_name)} timeMillis:  ${timeMillis.toString()}")
    }
}