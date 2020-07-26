package hn.com.data

import hn.com.entities.Stay

interface LocalDataSourceStay {
    suspend fun saveStay(stay: Stay)
    suspend fun getLatestStay(plate: String)
    suspend fun getTimeById(id: Int)
    suspend fun deleteStayByType(id_type: Int)
}