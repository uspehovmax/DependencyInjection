package ru.uspehovmax.dependencyinjection.data.datasource

import ru.uspehovmax.dependencyinjection.data.database.ExampleDatabase
import javax.inject.Inject

class ExampleLocalDataSourceImpl @Inject constructor  (
    private val database: ExampleDatabase
): ExampleLocalDataSource {

    override fun method() {
        database.method()
    }

}