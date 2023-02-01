package ru.uspehovmax.dependencyinjection.data.database

import android.content.Context
import android.util.Log
import ru.uspehovmax.dependencyinjection.R
import ru.uspehovmax.dependencyinjection.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Singleton

//@ApplicationScope // убрали
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
        Log.d(LOG_MSG, "$this - $message - ${context.getString(R.string.app_name)} - timeMillis: $timeMillis")
    }
}