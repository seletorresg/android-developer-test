package hn.com.parking.data.database.room

import hn.com.data.LocalDataSourceStay
import hn.com.entities.Stay
import hn.com.parking.data.database.ParkingDataBase
import hn.com.parking.data.toStayRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSourceStay(database: ParkingDataBase) :LocalDataSourceStay {
    private val stayDao = database.stayDao()
    override suspend fun saveStay(stay: Stay) {
        withContext(Dispatchers.IO) {stayDao.saveStay(stay.toStayRoom())}
    }

    override suspend fun getLatestStay(plate: String) {
       return withContext(Dispatchers.IO) {stayDao.getLatestStay(plate)}
    }

    override suspend fun getTimeById(id: Int) {
        return withContext(Dispatchers.IO) {stayDao.getTimeById(id)}
    }

    override suspend fun deleteStayByType(id_type: Int) {
        return withContext(Dispatchers.IO) {stayDao.deleteStayByType(id_type)}
    }

}