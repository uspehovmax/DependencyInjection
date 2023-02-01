package ru.uspehovmax.dependencyinjection.presentatopn

import android.app.Application
import ru.uspehovmax.dependencyinjection.di.DaggerApplicationComponent

class ExampleApplication: Application() {
/*
В манифесте нужно указать в разделе  <application> android:name=".presentatopn.ExampleApplication"
 */

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this, System.currentTimeMillis())
    }

}