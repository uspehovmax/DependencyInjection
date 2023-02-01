package ru.uspehovmax.dependencyinjection.presentatopn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.uspehovmax.dependencyinjection.R
import ru.uspehovmax.dependencyinjection.di.DaggerApplicationComponent
import javax.inject.Inject
import java.lang.*

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ExampleViewModel

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

    // 3. DaggerApplicationComponent делается через Factory. .create(application,timeMillis(timeMillis)  )
    private val component by lazy {
        DaggerApplicationComponent.factory().create(application, System.currentTimeMillis())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* нет инициализации  - краш.
        Инициализируем через DI - Dagger2
        Для инъекции вставляем аннотацию @Inject constructor() перед всеми классами
        ExampleDatabase, ExampleLocalDataSourceImpl ...
         */

        component.inject(this)

        // Для инициализации viewModel используется Dagger через
        // инъекцию конструктора viewModel @Inject
        viewModel.method()


    }
}