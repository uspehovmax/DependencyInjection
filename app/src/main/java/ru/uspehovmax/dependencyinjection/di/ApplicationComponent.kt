package ru.uspehovmax.dependencyinjection.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.uspehovmax.dependencyinjection.data.database.ExampleDatabase
import ru.uspehovmax.dependencyinjection.data.network.ExampleApiService
import ru.uspehovmax.dependencyinjection.presentatopn.ExampleViewModel
import ru.uspehovmax.dependencyinjection.presentatopn.MainActivity
import ru.uspehovmax.dependencyinjection.presentatopn.MainActivity2

@ApplicationScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class/*, ContextModule::class*/])
interface ApplicationComponent {
    /*Чтобы добавить в Граф Зависимостей DG объект - нужно создать метод в @Component.Builder
    Аннтотация @BindsInstance говорит что нужно вставить в DG данный метод и возвращаеммый объект
    */
    fun inject(activity: MainActivity)
    fun inject(activity: MainActivity2)

    /*    // 1 вариант @Component.Builder. через @BindsInstance - и добавление в MainActivity ....timeMillis(timeMillis)
        @Component.Builder
        interface ApplicationComponentBuilder {
            fun build(): ApplicationComponent

            @BindsInstance
            fun timeMillis(time: Long): ApplicationComponentBuilder

            @BindsInstance
            fun context(context: Context): ApplicationComponentBuilder
        }
    */
    // 2 вариант
    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(
            // в виде параметров - аналогично @Component.Builder
            @BindsInstance context: Context,
            @BindsInstance timeMillis: Long
        ): ApplicationComponent
    }

//    fun getViewModel(): ExampleViewModel
//
//    fun getDatabase(): ExampleDatabase
//
//    fun getApiService(): ExampleApiService
}