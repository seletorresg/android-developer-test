package hn.com.parking.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Type (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val description:String,
    val price:Double
)