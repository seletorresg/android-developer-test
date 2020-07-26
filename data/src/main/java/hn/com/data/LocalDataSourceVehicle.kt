package hn.com.data

import hn.com.entities.Vehicle

interface LocalDataSourceVehicle {
    suspend fun createVehicle(vehicle: Vehicle)
}