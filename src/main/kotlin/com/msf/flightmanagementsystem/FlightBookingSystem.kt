package com.msf.flightmanagementsystem

import java.time.Duration
import java.time.LocalDateTime

class FlightBookingSystem {
    val flights: MutableList<Flight> = mutableListOf()
    val passengers: MutableList<Passenger> = mutableListOf()

    // Adds a flight to the booking system.
    fun addFlight(flight: Flight) {
        if (flight.departureTime.isBefore(flight.arrivalTime)) {
            flights.add(flight)
            println("Flight added to the booking system.")
        } else {
            println("Invalid flight: Arrival time is earlier than departure time.")
        }
    }

    // Removes a flight from the booking system based on the flight number.
    fun removeFlight(flightNumber: String) {
        val removedFlight = flights.find { it.flightNumber == flightNumber }
        if (removedFlight != null) {
            flights.remove(removedFlight)
            println("Flight removed from the booking system.")
        } else {
            println("Flight number is not available.")
        }
    }

    // Adds a passenger to the booking system.
    fun addPassenger(passenger: Passenger) {
        passengers.add(passenger)
        println("Passenger has been added to the passengers list successfully.")
    }

    // Removes a passenger from the booking system based on their ID.
    fun removePassengerById(passengerId: String) {
        val removedPassenger = passengers.find { it.id == passengerId }
        if (removedPassenger != null) {
            passengers.remove(removedPassenger)
            println("Passenger has been removed from the passengers list by ID.")
        } else {
            println("Passenger with the given ID was not found.")
        }
    }

    // Searches for flights based on the source airport, destination airport, and departure time.
    fun searchFlights(source: String, destination: String, departureTime: LocalDateTime): List<Flight> {
        return flights.filter { it.source == source && it.destination == destination && it.departureTime == departureTime }
    }

    // Prints the details of a passenger based on their ID.
    fun printPassengerDetails(passengerId: String) {
        val passenger = passengers.find { it.id == passengerId }
        if (passenger != null) {
            println("-------- Passenger Details --------")
            println("ID: ${passenger.id}")
            println("Name: ${passenger.name}")
            println("-------- Booked Flights --------")
            for (flight in passenger.flights) {
                println("Flight Number: ${flight.flightNumber}")
                println("Source: ${flight.source}")
                println("Destination: ${flight.destination}")
                println("Departure Time: ${flight.departureTime}")
                println("Arrival Time: ${flight.arrivalTime}\n")
            }
        } else {
            println("Passenger not found.")
        }
    }

    // Prints the details of all passengers in the booking system.
    fun printAllPassengers() {
        if (passengers.isNotEmpty()) {

            for (passenger in passengers) {
                println("-------- Passenger Details --------")
                println("ID: ${passenger.id}")
                println("Name: ${passenger.name}")
                println("-------- Booked Flights ------------")
                if (flights.isNotEmpty()) {
                    for (flight in passenger.flights) {
                        println("Flight Number: ${flight.flightNumber}")
                        println("Source: ${flight.source}")
                        println("Destination: ${flight.destination}")
                        println("Departure Time: ${flight.departureTime}")
                        println("Arrival Time: ${flight.arrivalTime}\n")
                    }
                }
                else{
                    println("No flights found")
                }
            }
        } else {
            println("No passengers found.")
        }
    }

    // Prints the details of a flight based on the flight number.
    fun printFlightDetails(flightNumber: String) {
        val flightDetails = flights.find { it.flightNumber == flightNumber }
        if (flightDetails != null) {
            println("-------- Flight Details --------")
            println("Flight Source: ${flightDetails.source}")
            println("Flight Destination: ${flightDetails.destination}")
            println("Departure Time: ${flightDetails.departureTime}")
            println("Arrival Time: ${flightDetails.arrivalTime}")
        } else {
            println("Flight not found with the given flight number.")
        }
    }

    // Returns the shortest flight from a given list of flights.
    fun getShortestFlight(flights: List<Flight>): Flight? {
        if (flights.isEmpty()) return null
        return flights.minByOrNull { Duration.between(it.departureTime, it.arrivalTime).toMinutes() }
    }

    // Returns the count of passengers booked on a specific flight.
    val getPassengerCountByFlight: (String) -> Int = { flightNumber ->
        passengers.count { passenger -> passenger.flights.any { it.flightNumber == flightNumber } }
    }

    // Process bookings by assigning flights to passengers.
    suspend fun processBookings(bookings: List<Pair<String, String>>) {
        for ((passengerId, flightNumber) in bookings) {
            val passenger = passengers.firstOrNull { it.id == passengerId }
            val flight = flights.firstOrNull { it.flightNumber == flightNumber }
            if (passenger != null && flight != null) {
                // Check if departure time is before arrival time
                if (flight.departureTime.isBefore(flight.arrivalTime)) {
                    passenger.bookFlight(flight)
                } else {
                    println("Invalid booking: Arrival time is earlier than departure time.")
                }
            }
        }
    }


}
