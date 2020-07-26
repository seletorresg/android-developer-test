package hn.com.usecases

import hn.com.data.LocalDataSourceResident
import hn.com.data.LocalDataSourceVehicle
import hn.com.entities.Resident

class SignUpResidentVehicle (
    private val localDataSourceVehicle: LocalDataSourceVehicle,
    private val localDataSourceResident: LocalDataSourceResident
){
    suspend fun invoke(resident: Resident){
        localDataSourceVehicle.createVehicle(resident.vehicle)
        localDataSourceResident.createResident(resident)
    }
}