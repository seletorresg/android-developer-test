package hn.com.parking.data.database.model

import androidx.room.Embedded
import androidx.room.Entity
import hn.com.parking.data.database.model.Type

@Entity(tableName = "vehicles")
data class Vehicle(
    val plate:String,
    @Embedded val type: Type
)