package hn.com.parking.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hn.com.parking.data.database.model.Entry
import java.sql.Time

@Dao
interface EntryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createEntry(entry: Entry)

    @Query("SELECT MAX(date) FROM Entry WHERE plate= :plate ")
    fun getLatestEntry(plate: Int): Time
}