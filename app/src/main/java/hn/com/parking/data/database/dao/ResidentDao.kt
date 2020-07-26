package hn.com.parking.data.database.dao

import androidx.room.*
import hn.com.parking.data.database.model.Resident

@Dao
interface ResidentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createResident(resident: Resident)

    @Update
    fun updateTime(resident: Resident)

    @Update
    fun resetTime(resident: Resident)

    @Query("SELECT * FROM residents")
    fun getAllResidents():List<Resident>
}