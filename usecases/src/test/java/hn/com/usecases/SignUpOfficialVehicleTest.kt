package hn.com.usecases

import hn.com.data.LocalDataSourceVehicle
import hn.com.parking.testshared.residentVehicle
import hn.com.parking.testshared.vehicle
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SignUpOfficialVehicleTest {
    @Mock
    lateinit var localDataSourceVehicle: LocalDataSourceVehicle

    lateinit var signUpOfficialVehicle: SignUpOfficialVehicle

    @Before
    fun setUseCase(){
        signUpOfficialVehicle = SignUpOfficialVehicle(localDataSourceVehicle)
    }

    @Test
    fun `check in a new official vehicle`(){
        runBlocking {
            val vehicle = vehicle.copy(plate = "TRE3456")
            signUpOfficialVehicle.invoke(vehicle)
        }
    }
}