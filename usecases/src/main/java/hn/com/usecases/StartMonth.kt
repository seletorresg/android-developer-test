package hn.com.usecases

import hn.com.data.LocalDataSourceResident
import hn.com.data.LocalDataSourceStay

class StartMonth (
    private val localDataSourceStay: LocalDataSourceStay,
    private val localDataSourceResident: LocalDataSourceResident
) {
    suspend fun invoke(id_type:Int){
        localDataSourceStay.deleteStayByType(id_type)
        val residents = localDataSourceResident.getAllResidents()
        residents.forEach {
            localDataSourceResident.updateTime(it)
        }
    }
}