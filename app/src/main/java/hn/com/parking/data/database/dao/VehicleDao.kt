package hn.com.parking.data.database.dao

import androidx.room.*
import hn.com.parking.data.database.model.Type
import hn.com.parking.data.database.model.Vehicle

@Dao
interface VehicleDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createVehicle(vehicle: Vehicle)
}