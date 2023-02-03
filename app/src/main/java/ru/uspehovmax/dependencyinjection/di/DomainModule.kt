package ru.uspehovmax.dependencyinjection.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.uspehovmax.dependencyinjection.data.repository.ExampleRepositoryImpl
import ru.uspehovmax.dependencyinjection.domain.ExampleRepository


@Module
interface DomainModule {

    // 1 вариант
/*    @Provides
    fun provideRepository(impl: ExampleRepositoryImpl): ExampleRepository {
        return impl
    }*/

    // 2 вариант. @Binds - Предпочтителен. меньше кода, скорость сбокри выше
/*     класс DataModule и методы должен быть абстрактными или DataModule - интерфес
     Т.к. не создаётся экз.класса и не вызывает методов
     @Provides - создаёт экз.класса и вызывает методы*/

    //@ApplicationScope  // чтобы сделать ExampleRepositoryImpl синглтоном, его зависимости в конструкторе тоже в одном экз.
    @Binds
    fun bindRepository(impl: ExampleRepositoryImpl): ExampleRepository

}