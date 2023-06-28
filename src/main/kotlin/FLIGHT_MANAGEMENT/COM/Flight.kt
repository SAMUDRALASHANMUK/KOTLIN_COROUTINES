package FLIGHT_MANAGEMENT.COM

import java.time.LocalDateTime

class Flight(var flightNumber: String, var source: String, var destination: String, var departureTime: LocalDateTime, var arrivalTime: LocalDateTime) {
    fun getFlightNumber(): String {
        return flightNumber
    }

    fun setFlightNumber(flightNumber: String) {
        this.flightNumber = flightNumber
    }

    fun getSource(): String {
        return source
    }

    fun setSource(source: String) {
        this.source = source
    }

    fun getDestination(): String {
        return destination
    }

    fun setDestination(destination: String) {
        this.destination = destination
    }

    fun getDepartureTime(): LocalDateTime {
        return departureTime
    }

    fun setDepartureTime(departureTime: LocalDateTime) {
        this.departureTime = departureTime
    }

    fun getArrivalTime(): LocalDateTime {
        return arrivalTime
    }

    fun setArrivalTime(arrivalTime: LocalDateTime) {
        this.arrivalTime = arrivalTime
    }
}