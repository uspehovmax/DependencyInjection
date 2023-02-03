package ru.uspehovmax.dependencyinjection.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import ru.uspehovmax.dependencyinjection.presentatopn.ExampleViewModel
import ru.uspehovmax.dependencyinjection.presentatopn.ExampleViewModel2

@Module
interface ViewModelModule {

    /*
    Чтобы избежать проблем при обфускации - в мапе-ключе не должно быть String, нужен класс ViewModel в качестве ключа,
    а в качестве значения в мапе - провайдер Provider<ViewModel>
    т.е. private val viewModelsProviders: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
    Создаем annotation class ViewModelKey(val value: KClass<out ViewModel>)
     */
    @IntoMap
    @ViewModelKey(ExampleViewModel::class)
    @Binds
    fun bindExampleViewModel(impl: ExampleViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ExampleViewModel2::class)
    @Binds
    fun bindExampleViewModel2(impl: ExampleViewModel2): ViewModel

}