package hn.com.entities

import java.time.LocalDateTime

data class Exit (
    val id: Int,
    val date: LocalDateTime,
    val plate: String
)