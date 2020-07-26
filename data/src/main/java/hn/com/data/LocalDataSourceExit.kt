package hn.com.data

import hn.com.entities.*
import java.sql.Time

interface LocalDataSourceExit {
    suspend fun createExit(exit: Exit)
    suspend fun getLatestExit(plate: Int): Time
}