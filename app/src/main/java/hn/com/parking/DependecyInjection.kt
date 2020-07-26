package hn.com.parking

import android.app.Application
import hn.com.parking.data.database.ParkingDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun Application.initDependecyInjection() {
    startKoin {
        androidLogger()
        androidContext(this@initDependecyInjection)
        modules(listOf(app))
    }
}

private val app = module {
    single { ParkingDataBase.build(get()) }
}