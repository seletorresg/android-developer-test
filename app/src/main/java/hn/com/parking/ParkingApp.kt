package hn.com.parking

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ParkingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initDependecyInjection()
    }
}