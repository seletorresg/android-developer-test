package hn.com.parking.data.database.room

import hn.com.data.LocalDataSourceVehicle
import hn.com.entities.Vehicle
import hn.com.parking.data.database.ParkingDataBase
import hn.com.parking.data.toVehicleRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSourceVehicle (database: ParkingDataBase):LocalDataSourceVehicle {
    private val vehicleDao = database.vehicleDao()
    override suspend fun createVehicle(vehicle: Vehicle) {
        withContext(Dispatchers.IO) {vehicleDao.createVehicle(vehicle.toVehicleRoom())}
    }
}