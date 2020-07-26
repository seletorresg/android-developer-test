package hn.com.usecases

import hn.com.data.LocalDataSourceVehicle
import hn.com.entities.Vehicle

class SignUpOfficialVehicle (
    private val localDataSourceVehicle: LocalDataSourceVehicle
){
    suspend fun invoke(vehicle: Vehicle){
        localDataSourceVehicle.createVehicle(vehicle)
    }
}