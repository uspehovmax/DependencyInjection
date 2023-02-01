package ru.uspehovmax.dependencyinjection.data.repository

import ru.uspehovmax.dependencyinjection.data.datasource.ExampleLocalDataSource
import ru.uspehovmax.dependencyinjection.data.datasource.ExampleRemoteDataSource
import ru.uspehovmax.dependencyinjection.data.mapper.ExampleMapper
import ru.uspehovmax.dependencyinjection.domain.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor (
/*
    Dagger не знает (ошибка сборки!) как реализовывать interface ExampleLocalDataSource и ExampleRemoteDataSource
    - нужно создать в модуле @Module class DataModule
    @Provide fun provideRemoteDataSource и @Provide fun provideLocalDataSource
    и вернуть реализации ExampleRemoteDataSourceImpl и ExampleLocalDataSourceImpl
    модуль добавить в @Component (modules = [...]..) в interface ApplicationComponent
*/
    private val localDataSource: ExampleLocalDataSource, // Dagger не знает как реализовывать ExampleLocalDataSource
    private val remoteDataSource: ExampleRemoteDataSource,// Dagger не знает как реализовывать ExampleRemoteDataSource
    private val mapper: ExampleMapper
) : ExampleRepository {

    override fun method() {
        mapper.map()
        localDataSource.method()
        remoteDataSource.method()
    }
}