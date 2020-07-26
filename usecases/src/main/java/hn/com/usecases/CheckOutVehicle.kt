package hn.com.usecases

import hn.com.data.*
import hn.com.entities.Resident
import hn.com.entities.Stay
import hn.com.entities.Vehicle

class CheckOutVehicle(
    private val localDataSourceResident: LocalDataSourceResident,
    private val localDataSourcePayment: LocalDataSourcePayment,
    private val localDataSourceStay: LocalDataSourceStay) {

    suspend fun invoke(vehicle: Vehicle,stay: Stay):Double {
        when(vehicle.type.id){
            0 -> {
                localDataSourceStay.saveStay(stay)
                return 0.0
            }
            1 -> {
                localDataSourceResident.updateTime(resident = Resident(stay.time,vehicle))
                return 0.0
            }
            2 -> {
                val time = stay.time
                val price = vehicle.type.price
                return localDataSourcePayment.calculatePayment(time,price);
            }
            else -> return 0.0
        }
    }
}