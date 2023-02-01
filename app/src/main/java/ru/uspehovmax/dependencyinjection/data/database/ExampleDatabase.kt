package ru.uspehovmax.dependencyinjection.data.database

import android.content.Context
import android.util.Log
import ru.uspehovmax.dependencyinjection.R
import javax.inject.Inject

class ExampleDatabase @Inject constructor(
    // чтобы передать context нужно в модуле DataModule добавить:
    // class DataModule(private val context: Context)
    private val context: Context,
    private val timeMillis: Long
)  {

    companion object {
        private const val LOG_MSG = "MSG"
        private const val message = "ExampleDatabase: "
    }

    fun method() {
        Log.d(LOG_MSG, message + timeMillis.toString() + " " + context.getString(R.string.app_name))
    }
}