package hn.com.usecases

import hn.com.data.LocalDataSourcePayment
import hn.com.data.LocalDataSourceResident
import hn.com.data.LocalDataSourceType
import hn.com.parking.testshared.residentVehicle
import hn.com.parking.testshared.stayResident
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetReportOfResidentsPaymentTest {
    @Mock
    lateinit var localDataSourceResident: LocalDataSourceResident
    @Mock
    lateinit var localDataSourcePayment: LocalDataSourcePayment

    lateinit var getReportOfResidentsPayment: GetReportOfResidentsPayment

    @Before
    fun setUseCase() {
        getReportOfResidentsPayment = GetReportOfResidentsPayment(localDataSourcePayment,localDataSourceResident)
    }

    @Test
    fun `create a new report of residents payments`(){
        runBlocking {
            val list = getReportOfResidentsPayment.invoke()
            val residents = localDataSourceResident.getAllResidents()
            Assert.assertEquals(list.size,residents.size)
        }
    }
}