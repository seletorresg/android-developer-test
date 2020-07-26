package hn.com.parking.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hn.com.parking.data.database.model.Type

@Dao
interface TypeDao{
    @Query("SELECT price FROM Type WHERE id = :id")
    fun getPriceByType(id: Int): Double

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createType(type: Type)
}