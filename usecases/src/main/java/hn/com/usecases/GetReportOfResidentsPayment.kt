package hn.com.usecases

import hn.com.data.LocalDataSourcePayment
import hn.com.data.LocalDataSourceResident
import hn.com.entities.LineReport

class GetReportOfResidentsPayment (
    private val localDataSourcePayment: LocalDataSourcePayment,
    private val localDataSourceResident: LocalDataSourceResident
){
    suspend fun invoke(): List<LineReport> {
        val residents = localDataSourceResident.getAllResidents()
        val paymentList:MutableList<LineReport> = arrayListOf()
        for (resident in residents) {
            val total = localDataSourcePayment.calculatePayment(resident.time,resident.vehicle.type.price)
            val line = LineReport(resident,total)
            paymentList.add(line)
        }
        return paymentList
    }
}