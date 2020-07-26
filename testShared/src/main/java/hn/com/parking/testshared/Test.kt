package hn.com.parking.testshared

import hn.com.entities.Stay
import hn.com.entities.Type
import hn.com.entities.Vehicle

    val officalType = Type(0,"Oficial",0.0)
    val residentType = Type(1,"Residente",0.5)
    val noResidentType = Type(2,"No Residente",0.5)
    val officialVehicle = Vehicle("PDF5678",officalType)
    val residentVehicle = Vehicle("FGH9807",residentType)
    val vehicle = Vehicle("DSA8076",noResidentType)
    val stay = Stay(3, vehicle,120)
    val stayResident = Stay(4, residentVehicle,30)
    val stayOfficial = Stay(5, officialVehicle,20)