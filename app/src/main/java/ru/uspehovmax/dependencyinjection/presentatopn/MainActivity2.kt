package ru.uspehovmax.dependencyinjection.presentatopn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.uspehovmax.dependencyinjection.R
import javax.inject.Inject
import java.lang.*

class MainActivity2 : AppCompatActivity() {

    // 4. Создали ExampleApplication. Из него получаем ссылку на component
    private val component by lazy {
        (application as ExampleApplication).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ExampleViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component.inject(this)

        viewModel.method()

    }
}