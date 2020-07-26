package hn.com.parking.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hn.com.parking.data.database.model.Exit
import java.sql.Time

@Dao
interface ExitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createExit(exit: Exit)

    @Query("SELECT MAX(date) FROM Exit WHERE plate= :plate ")
    fun getLatestExit(plate: Int): Time
}