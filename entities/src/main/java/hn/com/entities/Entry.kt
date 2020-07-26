package hn.com.entities

import java.time.LocalDateTime

data class Entry (
    val id: Int,
    val date: LocalDateTime,
    val plate: String
)