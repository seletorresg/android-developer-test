package hn.com.parking.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.time.LocalDateTime

@Entity
data class Exit (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: LocalDateTime,
    val plate: String
)