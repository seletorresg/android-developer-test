package hn.com.parking.data.database.room

import hn.com.data.LocalDataSourceEntry
import hn.com.entities.Entry
import hn.com.parking.data.database.ParkingDataBase
import hn.com.parking.data.toEntryRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.Time

class RoomDataSourceEntry(database: ParkingDataBase): LocalDataSourceEntry {
    private val entryDao = database.entryDao()

    override suspend fun createEntry(entry: Entry) {
        withContext(Dispatchers.IO) {
            entryDao.createEntry(entry.toEntryRoom())
        }
    }

    override suspend fun getLatestEntry(plate: Int): Time {
        return withContext(Dispatchers.IO) {
            entryDao.getLatestEntry(plate)
        }
    }
}