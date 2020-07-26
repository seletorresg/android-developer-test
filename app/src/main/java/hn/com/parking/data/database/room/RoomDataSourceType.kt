package hn.com.parking.data.database.room

import hn.com.data.LocalDataSourceType
import hn.com.entities.Type
import hn.com.parking.data.database.ParkingDataBase
import hn.com.parking.data.toTypeRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSourceType (database: ParkingDataBase): LocalDataSourceType {
    private val typeDao = database.typeDao()
    override suspend fun getPriceByType(id: Int): Double {
        return withContext(Dispatchers.IO) {typeDao.getPriceByType(id)}
    }

    override suspend fun createType(type: Type) {
        withContext(Dispatchers.IO){typeDao.createType(type.toTypeRoom())}
    }
}