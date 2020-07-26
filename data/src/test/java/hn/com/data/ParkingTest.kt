package hn.com.data

import com.nhaarman.mockitokotlin2.whenever
import hn.com.entities.Entry
import hn.com.entities.Exit
import hn.com.parking.testshared.noResidentType
import hn.com.parking.testshared.vehicle as testVehicle
import hn.com.parking.testshared.residentVehicle
import hn.com.parking.testshared.officialVehicle
import hn.com.parking.testshared.stay
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.time.LocalDateTime

@RunWith(MockitoJUnitRunner::class)
class ParkingTest {
    @Mock
    lateinit var localDataSourceResident: LocalDataSourceResident
    @Mock
    lateinit var localDataSourceStay: LocalDataSourceStay
    @Mock
    lateinit var localDataSourceVehicle: LocalDataSourceVehicle
    @Mock
    lateinit var localDataSourceType: LocalDataSourceType
    @Mock
    lateinit var localDataSourcePayment: LocalDataSourcePayment
    @Mock
    lateinit var localDataSourceEntry: LocalDataSourceEntry
    @Mock
    lateinit var localDataSourceExit: LocalDataSourceExit

    @Test
    fun `add a new entry official vehicle`() {
        runBlocking {
            localDataSourceEntry.createEntry(Entry(0,LocalDateTime.now(), officialVehicle.plate))
        }
    }

    @Test
    fun `add a new exit official vehicle`() {
        runBlocking {
            localDataSourceExit.createExit(Exit(0, LocalDateTime.now(),officialVehicle.plate))
        }
    }

    @Test
    fun `add a new entry resident vehicle`() {
        runBlocking {
            localDataSourceEntry.createEntry(Entry(1,LocalDateTime.now(), residentVehicle.plate))
        }
    }

    @Test
    fun `add a new exit resident vehicle`() {
        runBlocking {
            localDataSourceExit.createExit(Exit(1, LocalDateTime.now(),residentVehicle.plate))
        }
    }

    @Test
    fun `add a new entry no resident vehicle`() {
        runBlocking {
            localDataSourceEntry.createEntry(Entry(2,LocalDateTime.now(), testVehicle.plate))
        }
    }

    @Test
    fun `add a new exit no resident vehicle`() {
        runBlocking {
            localDataSourceExit.createExit(Exit(2, LocalDateTime.now(),testVehicle.plate))
        }
    }

    @Test
    fun `get time sending the id of a stay`() {
        runBlocking {
            val stay = stay.copy(id = 5)
            localDataSourceStay.getTimeById(5)
        }
    }


}

