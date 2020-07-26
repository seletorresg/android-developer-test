package hn.com.parking.data.database.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "residents")
data class Resident(
    val time:Int,
    @Embedded val vehicle: Vehicle
)