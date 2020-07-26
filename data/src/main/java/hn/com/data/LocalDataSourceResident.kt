package hn.com.data

import hn.com.entities.Resident

interface LocalDataSourceResident {
    suspend fun createResident(resident: Resident)
    suspend fun updateTime(resident: Resident)
    suspend fun resetTime(resident: Resident)
    suspend fun getAllResidents():List<Resident>
}