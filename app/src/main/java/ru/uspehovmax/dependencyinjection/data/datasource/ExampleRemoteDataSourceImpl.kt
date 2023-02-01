package ru.uspehovmax.dependencyinjection.data.datasource

import ru.uspehovmax.dependencyinjection.data.network.ExampleApiService
import javax.inject.Inject

class ExampleRemoteDataSourceImpl @Inject constructor (
    private val apiService: ExampleApiService
): ExampleRemoteDataSource {

    override fun method() {
        apiService.method()
    }

}