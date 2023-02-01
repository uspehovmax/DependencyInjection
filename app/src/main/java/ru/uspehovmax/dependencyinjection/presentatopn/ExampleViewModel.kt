package ru.uspehovmax.dependencyinjection.presentatopn

import ru.uspehovmax.dependencyinjection.domain.ExampleUseCase
import javax.inject.Inject

class ExampleViewModel @Inject constructor(
    private val useCase: ExampleUseCase
) {

    fun method() {
        useCase.invoke()
    }

}