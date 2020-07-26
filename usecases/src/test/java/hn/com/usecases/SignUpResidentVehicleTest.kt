package hn.com.usecases

import hn.com.data.LocalDataSourceResident
import hn.com.data.LocalDataSourceVehicle
import hn.com.entities.Resident
import hn.com.parking.testshared.residentVehicle
import hn.com.parking.testshared.vehicle
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SignUpResidentVehicleTest {
    @Mock
    lateinit var localDataSourceVehicle: LocalDataSourceVehicle
    @Mock
    lateinit var localDataSourceResident: LocalDataSourceResident

    lateinit var signUpResidentVehicle: SignUpResidentVehicle

    @Before
    fun setUseCase(){
        signUpResidentVehicle = SignUpResidentVehicle(localDataSourceVehicle,localDataSourceResident)
    }

    @Test
    fun `check in a new resident vehicle`(){
        runBlocking {
            val vehicle = residentVehicle.copy(plate = "SGA3456")
            val resident = Resident(0,vehicle)
            signUpResidentVehicle.invoke(resident)
        }
    }
}