package hn.com.parking.data.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stay (
    @PrimaryKey(autoGenerate = true) val id_stay: Int,
    @Embedded val vehicle: Vehicle,
    val time:Int
)