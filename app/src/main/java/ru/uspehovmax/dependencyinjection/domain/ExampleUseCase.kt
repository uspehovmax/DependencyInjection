package ru.uspehovmax.dependencyinjection.domain

import javax.inject.Inject

class ExampleUseCase @Inject constructor (
/*
    Dagger не знает (ошибка сборки!) как реализовать interface ExampleRepository - нужно создать в модуле
    @Module
    class DomainModule в нем создать @Provide fun provideRepository и вернуть реализацию ExampleRepositoryImpl
    модуль добавить в @Component (modules = [...]..) в interface ApplicationComponent
*/
    private val repository: ExampleRepository
) {
    operator fun invoke() {
        repository.method()
    }
}