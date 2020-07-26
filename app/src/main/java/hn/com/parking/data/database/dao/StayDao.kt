package hn.com.parking.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hn.com.parking.data.database.model.Stay

@Dao
interface StayDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveStay(stay: Stay)

    @Query("SELECT MAX(id) FROM Stay WHERE plate= :plate")
    fun getLatestStay(plate: String)

    @Query("SELECT time FROM Stay WHERE id_stay= :id")
    fun getTimeById(id: Int)

    @Query("DELETE FROM Stay WHERE id = :id_type")
    fun deleteStayByType(id_type: Int)
}