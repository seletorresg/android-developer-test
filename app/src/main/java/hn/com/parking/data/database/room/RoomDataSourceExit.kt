package hn.com.parking.data.database.room

import hn.com.data.LocalDataSourceExit
import hn.com.entities.Exit
import hn.com.parking.data.database.ParkingDataBase
import hn.com.parking.data.toExitRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.Time

class RoomDataSourceExit (database: ParkingDataBase): LocalDataSourceExit {
    private val exitDao = database.exitDao()
    override suspend fun createExit(exit: Exit) {
        withContext(Dispatchers.IO) {
            exitDao.createExit(exit.toExitRoom())
        }
    }

    override suspend fun getLatestExit(plate: Int): Time {
        return withContext(Dispatchers.IO){
            exitDao.getLatestExit(plate)
        }
    }


}