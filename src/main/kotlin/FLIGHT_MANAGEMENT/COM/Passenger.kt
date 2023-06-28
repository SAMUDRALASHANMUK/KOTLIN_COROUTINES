package FLIGHT_MANAGEMENT.COM

import java.time.Duration
class Passenger(var id: String, var name: String, var flights: MutableList<Flight> = mutableListOf()) {
    fun getId(): String {
        return id
    }
    fun setId(id: String) {
        this.id = id
    }
    fun getName(): String {
        return name
    }
    fun setName(name: String) {
        this.name = name
    }
    fun bookFlight(flight: Flight) {
        flights.add(flight)
    }
    fun cancelFlight(flightNumber: String) {
        val flightToRemove = flights.find { it.getFlightNumber() == flightNumber }
        flights.remove(flightToRemove)
    }
    fun getTotalTravelTime(): Duration {
        var totalTravelTime = Duration.ZERO
        for (flight in flights) {
            val travelTime = Duration.between(flight.getDepartureTime(), flight.getArrivalTime())
            totalTravelTime = totalTravelTime.plus(travelTime)
        }
        return totalTravelTime
    }


}