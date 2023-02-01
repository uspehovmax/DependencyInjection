package ru.uspehovmax.dependencyinjection.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.uspehovmax.dependencyinjection.presentatopn.MainActivity

@Component (modules = [DataModule::class, DomainModule::class/*, ContextModule::class*/])
interface ApplicationComponent {
    /*Чтобы добавить в Граф Зависимостей DG объект - нужно создать метод в @Component.Builder
    Аннтотация @BindsInstance говорит что нужно вставить в DG данный метод и возвращаеммый объект
    */
    fun inject(activity: MainActivity)

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

}