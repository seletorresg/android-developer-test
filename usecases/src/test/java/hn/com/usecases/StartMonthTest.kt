package hn.com.usecases

import hn.com.data.LocalDataSourcePayment
import hn.com.data.LocalDataSourceResident
import hn.com.data.LocalDataSourceStay
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StartMonthTest{
    @Mock
    lateinit var localDataSourceResident: LocalDataSourceResident
    @Mock
    lateinit var localDataSourceStay: LocalDataSourceStay

    lateinit var startMonth: StartMonth

    @Before
    fun setUseCase() {
        startMonth = StartMonth(localDataSourceStay,localDataSourceResident)
    }

    @Test
    fun `start a new month`(){
        runBlocking {
            startMonth.invoke(0)
        }
    }
}