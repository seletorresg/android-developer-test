package hn.com.parking.data.database.room

import hn.com.data.LocalDataSourceResident
import hn.com.entities.Resident
import hn.com.parking.data.database.ParkingDataBase
import hn.com.parking.data.toResidentDomain
import hn.com.parking.data.toResidentRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSourceResident (database: ParkingDataBase): LocalDataSourceResident {
    private val residentDao = database.residentDao()
    override suspend fun createResident(resident: Resident) {
        withContext(Dispatchers.IO) { residentDao.createResident(resident.toResidentRoom()) }
    }

    override suspend fun updateTime(resident: Resident) {
        withContext(Dispatchers.IO) { residentDao.updateTime(resident.toResidentRoom()) }
    }

    override suspend fun resetTime(resident: Resident) {
        withContext(Dispatchers.IO) { residentDao.resetTime(resident.toResidentRoom()) }
    }

    override suspend fun getAllResidents(): List<Resident> {
        return withContext(Dispatchers.IO) {residentDao.getAllResidents().map { it.toResidentDomain() }}
    }


}