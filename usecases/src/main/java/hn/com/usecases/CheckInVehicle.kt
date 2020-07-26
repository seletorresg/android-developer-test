package hn.com.usecases

import hn.com.data.LocalDataSourceVehicle
import hn.com.entities.Vehicle


class CheckInVehicle(private val localDataSource: LocalDataSourceVehicle) {
    suspend fun invoke(vehicle: Vehicle) = localDataSource.createVehicle(vehicle)
}