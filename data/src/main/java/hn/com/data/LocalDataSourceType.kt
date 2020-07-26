package hn.com.data

import hn.com.entities.Type

interface LocalDataSourceType {
    suspend fun getPriceByType(id: Int): Double
    suspend fun createType(type: Type)
}