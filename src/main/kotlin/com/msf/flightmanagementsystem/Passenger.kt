package com.msf.flightmanagementsystem

import java.time.Duration

// Passenger class representing a passenger with their properties and methods
class Passenger(var id: String, var name: String, var flights: MutableList<Flight> = mutableListOf()) {

    // Books a flight for the passenger by adding it to their booked flights
    fun bookFlight(flight: Flight) {
        flights.add(flight)
        println("Flight booked successfully.")
    }

    // Cancels a flight booking based on the flight number
    fun cancelFlight(flightNumber: String) {
        var passengerFlight = flights.find { it.flightNumber == flightNumber }
        if (passengerFlight != null) {
            flights.remove(passengerFlight)
            println("Flight has been canceled.")
        } else {
            println("Flight number not found.")
        }
    }

    // Calculates and returns the total travel time of all flights booked by the passenger
    fun getTotalTravelTime(): Duration {
        var totalTravelTime = Duration.ZERO
        flights.forEach {
            val travelTime = Duration.between(it.departureTime, it.arrivalTime)
            totalTravelTime = totalTravelTime.plus(travelTime)
        }
        return totalTravelTime
    }
}