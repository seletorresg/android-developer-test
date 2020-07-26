package hn.com.parking.data

import hn.com.entities.Entry as EntryDomain
import hn.com.entities.Resident as ResidentDomain
import hn.com.entities.Vehicle as VehicleDomain
import hn.com.entities.Type as TypeDomain
import hn.com.entities.Stay as StayDomain
import hn.com.entities.Exit as ExitDomain

import hn.com.parking.data.database.model.Entry
import hn.com.parking.data.database.model.Resident
import hn.com.parking.data.database.model.Type
import hn.com.parking.data.database.model.Vehicle
import hn.com.parking.data.database.model.Exit
import hn.com.parking.data.database.model.Stay

fun Resident.toResidentDomain(): ResidentDomain =
    ResidentDomain(
        time,
        vehicle.toVehicleDomain()
    )

fun ResidentDomain.toResidentRoom(): Resident =
    Resident(
        time,
        vehicle.toVehicleRoom()
    )

fun Vehicle.toVehicleDomain(): VehicleDomain =
    VehicleDomain(
        plate,
        type.toTypeDomain()
    )

fun VehicleDomain.toVehicleRoom(): Vehicle =
    Vehicle(
        plate,
        type.toTypeRoom()
    )

fun Type.toTypeDomain(): TypeDomain =
    TypeDomain(
        id, description, price
    )

fun TypeDomain.toTypeRoom(): Type =
    Type(
        id, description, price
    )

fun Entry.toEntryDomain(): EntryDomain =
    EntryDomain(
        id,
        date,
        plate
    )

fun EntryDomain.toEntryRoom(): Entry =
    Entry(
        id,
        date,
        plate
    )

fun Exit.toExitDomain(): ExitDomain = ExitDomain(id,date,plate)

fun ExitDomain.toExitRoom(): Exit = Exit(id,date,plate)

fun Stay.toStayDomain(): StayDomain = StayDomain(id_stay,vehicle.toVehicleDomain(),time)

fun StayDomain.toStayRoom(): Stay = Stay(id,vehicle.toVehicleRoom(),time)