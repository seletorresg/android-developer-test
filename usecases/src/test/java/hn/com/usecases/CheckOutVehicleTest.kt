package hn.com.usecases

import hn.com.data.*
import hn.com.parking.testshared.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CheckOutVehicleTest {
    @Mock
    lateinit var localDataSourceResident: LocalDataSourceResident
    @Mock
    lateinit var localDataSourceType: LocalDataSourceType
    @Mock
    lateinit var localDataSourcePayment: LocalDataSourcePayment
    @Mock
    lateinit var localDataSourceStay: LocalDataSourceStay

    lateinit var checkOutVehicle: CheckOutVehicle

    @Before
    fun setUseCase(){
        checkOutVehicle = CheckOutVehicle(localDataSourceResident,localDataSourcePayment,localDataSourceStay)
    }

    @Test
    fun `create the types`(){
        runBlocking {
            localDataSourceType.createType(residentType)
            localDataSourceType.createType(officalType)
            localDataSourceType.createType(noResidentType)
        }
    }

    @Test
    fun `check out a resident vehicle`(){
        runBlocking {
            val payment = checkOutVehicle.invoke(residentVehicle, stayResident)
            Assert.assertEquals(0.0,payment,0.0)
        }
    }

    @Test
    fun `check out a official vehicle`(){
        runBlocking {
            val payment = checkOutVehicle.invoke(officialVehicle, stayOfficial)
            Assert.assertEquals(0.0,payment,0.0)
        }
    }

    @Test
    fun `check out a no resident vehicle`(){
        runBlocking {
            val payment = checkOutVehicle.invoke(vehicle, stay)
            val total = stay.time * 0.5
            Assert.assertEquals(total,payment,0.0)
        }
    }
}