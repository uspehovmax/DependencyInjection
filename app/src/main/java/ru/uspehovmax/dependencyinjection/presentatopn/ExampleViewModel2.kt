package ru.uspehovmax.dependencyinjection.presentatopn

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.uspehovmax.dependencyinjection.domain.ExampleRepository
import ru.uspehovmax.dependencyinjection.domain.ExampleUseCase
import javax.inject.Inject

class ExampleViewModel2 @Inject constructor(
    private val repository: ExampleRepository
): ViewModel()  {

    fun method() {
        repository.method()
        Log.d("ExampleViewModel2", "$this")
    }

}