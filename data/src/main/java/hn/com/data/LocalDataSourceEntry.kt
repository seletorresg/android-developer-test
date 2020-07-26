package hn.com.data

import hn.com.entities.*
import java.sql.Time

interface LocalDataSourceEntry {
    suspend fun createEntry(entry: Entry)
    suspend fun getLatestEntry(plate: Int): Time
}