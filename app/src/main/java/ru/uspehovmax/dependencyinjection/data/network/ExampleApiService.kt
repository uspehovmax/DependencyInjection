package ru.uspehovmax.dependencyinjection.data.network

import android.content.Context
import android.util.Log
import ru.uspehovmax.dependencyinjection.R
import javax.inject.Inject

class ExampleApiService @Inject constructor(
    private val context: Context,
    private val timeMillis: Long
) {

    companion object {
        private const val LOG_MSG = "MSG"
        private const val message = "ExampleApiService: "
    }

    fun method() {
        Log.d(LOG_MSG, message + timeMillis.toString() + " " + context.getString(R.string.app_name))
    }
}