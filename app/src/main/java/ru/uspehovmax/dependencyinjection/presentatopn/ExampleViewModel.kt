package ru.uspehovmax.dependencyinjection.presentatopn

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.uspehovmax.dependencyinjection.domain.ExampleUseCase
import javax.inject.Inject

class ExampleViewModel @Inject constructor(
    private val useCase: ExampleUseCase
): ViewModel()  {

    fun method() {
        useCase()
        Log.d("ExampleViewModel", "$this")
    }

}