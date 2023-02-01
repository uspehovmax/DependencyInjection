package ru.uspehovmax.dependencyinjection.presentatopn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.uspehovmax.dependencyinjection.R
import ru.uspehovmax.dependencyinjection.data.database.ExampleDatabase
import ru.uspehovmax.dependencyinjection.di.DaggerApplicationComponent
import javax.inject.Inject
import java.lang.*

class MainActivity : AppCompatActivity() {

    private val timeMillis = System.currentTimeMillis()
/*   // 1. DaggerApplicationComponent генерируется при сборке.
     //Если все модули @Component имеют пустой конструктор (т.е. не передаются параметры) исп-я .create()
    private val component = DaggerApplicationComponent.create()*/

/*   // 2. DaggerApplicationComponent делается через .builder(), если нужно передать парметр(-ы)
     //добавление "вручную"
     //в контекст -> .dataModule(DataModule(this))
    private val component by lazy {
        DaggerApplicationComponent.builder()
            //.contextModule(ContextModule(application)) // убрали, вместо этого стал @Component.Builder
            .context(application)
            .timeMillis(timeMillis)
            .build()
    }*/

/*    // 3. DaggerApplicationComponent делается через Factory. .create(application,timeMillis(timeMillis)  )
    private val component by lazy {
        DaggerApplicationComponent.factory()
            .create(application, System.currentTimeMillis())
    }*/

    // 4. Создали ExampleApplication. Из него получаем ссылку на component
    private val component by lazy {
        (application as ExampleApplication).component
    }

    @Inject // заменяем
    lateinit var viewModel: ExampleViewModel
    // получаем viewModel через инъекцию
/*    private val viewModel: ExampleViewModel by lazy {
        component.getViewModel()
}*/

    // получаем database через инъекцию
/*    private val database: ExampleDatabase by lazy {
        component.getDatabase()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* нет инициализации  - краш.
        Инициализируем через DI - Dagger2
        Для инъекции вставляем аннотацию @Inject constructor() перед всеми классами
        ExampleDatabase, ExampleLocalDataSourceImpl ...
         */

        component.inject(this)

/*        Log.d("MSG", "MainActivity ${component.getViewModel()}")
        Log.d("MSG", "MainActivity ${component.getViewModel()}")
        Log.d("MSG", "MainActivity ${component.getDatabase()}")
        Log.d("MSG", "MainActivity ${component.getDatabase()}")
        Log.d("MSG", "MainActivity ${component.getApiService()}")
        Log.d("MSG", "MainActivity ${component.getApiService()}")*/

        // Для инициализации viewModel используется Dagger через
        // инъекцию конструктора viewModel @Inject
        viewModel.method()
//        database.method()


    }
}