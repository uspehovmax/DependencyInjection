package ru.uspehovmax.dependencyinjection.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.uspehovmax.dependencyinjection.data.datasource.ExampleLocalDataSource
import ru.uspehovmax.dependencyinjection.data.datasource.ExampleLocalDataSourceImpl
import ru.uspehovmax.dependencyinjection.data.datasource.ExampleRemoteDataSource
import ru.uspehovmax.dependencyinjection.data.datasource.ExampleRemoteDataSourceImpl

@Module
interface DataModule /*(private val context: Context)*/ {

    // 1 вариант
/*    @Provides
    fun provideLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource {
        return impl
    }

    @Provides
    fun provideRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource {
        return impl
    }*/

    // чтобы Dagger мог передать контекст в ExampleDatabase
/*    @Provides
    fun provideContext(): Context {
        return context
    }*/

    // 2 вариант. @Binds - Предпочтителен. меньше кода, скорость сбокри выше
/*     класс DataModule и методы должен быть абстрактными или DataModule - интерфес
     Т.к. не создаётся экз.класса и не вызывает методов
     @Provides - создаёт экз.класса и вызывает методы*/
    @ApplicationScope // чтобы сделать ExampleLocalDataSourceImpl синглтоном, его зависимости в конструкторе тоже в одном экз.
    @Binds
    fun bindLocalDataSource(impl: ExampleLocalDataSourceImpl): ExampleLocalDataSource

    @ApplicationScope // чтобы сделать ExampleRemoteDataSourceImpl синглтоном, его зависимости в конструкторе тоже в одном экз.
    @Binds
    fun bindRemoteDataSource(impl: ExampleRemoteDataSourceImpl): ExampleRemoteDataSource

}