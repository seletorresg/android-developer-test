package hn.com.parking.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hn.com.parking.data.database.dao.*
import hn.com.parking.data.database.model.*

@Database(entities = [Vehicle::class, Resident::class, Entry::class, Exit::class, Stay::class
    , Type::class], version = 1)
abstract class ParkingDataBase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            ParkingDataBase::class.java,
            "parking-db"
        ).build()
    }

    abstract fun residentDao(): ResidentDao
    abstract fun vehicleDao(): VehicleDao
    abstract fun entryDao(): EntryDao
    abstract fun exitDao(): ExitDao
    abstract fun stayDao(): StayDao
    abstract fun typeDao(): TypeDao
}