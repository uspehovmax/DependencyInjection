package ru.uspehovmax.dependencyinjection.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

//@Module // удалили из зависимостей
class ContextModule(private val application: Application) {

/*   Внутри ГрафаЗависимостей Dependency Graph DP нужен контекст
     на этапе компиляции контекста нет и его не откуда взять
     Поэтому контекст передаётся в виде параметра модулю ContextModule
     в методе provideContext добавляем контекст в DP
     */
//    @Provides
//    fun provideContext(): Context {
//        return application
//    }

}