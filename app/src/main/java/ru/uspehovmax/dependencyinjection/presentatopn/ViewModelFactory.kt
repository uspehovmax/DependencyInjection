package ru.uspehovmax.dependencyinjection.presentatopn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.uspehovmax.dependencyinjection.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
class ViewModelFactory @Inject constructor(
    //private val exampleUseCase: ExampleUseCase // плохое решение
    private val viewModelsProviders: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>

): ViewModelProvider.Factory {

    /*
    Решение с передачей ExampleViewModel в виде параметра в ExampleViewModelFactory не хорошее, нужны проверки
    и при большом кол-ве ViewModel - будет нагромождение.
    Нужна коллекция.
     */

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // плохое решение
/*        if (modelClass == ExampleViewModel::class.java) {
            return ExampleViewModel(exampleUseCase) as T
        }
        throw RuntimeException("Unknown view model class $modelClass")*/

        // верное решение через viewModels: Map<Class<out ViewModel>, Provider<ViewModel>>
        // в качестве ключа используется ... в качестве параметра  Provider<ViewModel>

        return viewModelsProviders[modelClass]?.get()  as T // приведение к типу Т для разных типов viewModel


    }
}