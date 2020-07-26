package hn.com.usecases

import hn.com.data.LocalDataSourceVehicle
import hn.com.parking.testshared.residentVehicle
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CheckInVehicleTest {
    @Mock
    lateinit var localDataSourceVehicle: LocalDataSourceVehicle

    lateinit var checkInVehicle: CheckInVehicle

    @Before
    fun setUseCase(){
        checkInVehicle = CheckInVehicle(localDataSourceVehicle)
    }

    @Test
    fun `check in a new resident vehicle`(){
        runBlocking {
            val vehicle = residentVehicle.copy(plate="HGF9076")
            checkInVehicle.invoke(vehicle)
        }
    }
}