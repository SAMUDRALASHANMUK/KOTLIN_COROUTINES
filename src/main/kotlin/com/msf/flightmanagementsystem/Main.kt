package com.msf.flightmanagementsystem


import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime


fun main() {

    val flightBookingSystem = FlightBookingSystem()

    // Adding flights to the booking system
    val flight1 = Flight(
        "ABC123",
        "Source1",
        "Destination1",
        LocalDateTime.parse("2023-07-05T08:00"),
        LocalDateTime.parse("2023-07-05T10:00")
    )
    val flight2 = Flight(
        "DEF456",
        "Source2",
        "Destination2",
        LocalDateTime.parse("2023-07-06T10:00"),
        LocalDateTime.parse("2023-07-06T12:00")
    )
    val flight3 = Flight(
        "GHI789",
        "Source3",
        "Destination3",
        LocalDateTime.parse("2023-07-07T12:00"),
        LocalDateTime.parse("2023-07-07T14:00")
    )
    val flight4 = Flight(
        "GHI788",
        "Source4",
        "Destination4",
        LocalDateTime.parse("2023-07-07T12:00"),
        LocalDateTime.parse("2023-07-07T14:00")
    )


    println("\n--------------------------------Add Flight Method-------------------------------------\n")

    flightBookingSystem.addFlight(flight1)
    flightBookingSystem.addFlight(flight2)
    flightBookingSystem.addFlight(flight3)
    flightBookingSystem.addFlight(flight4)

    println("\n--------------------------------------------------------------------------------------\n\n")


    // Removes a flight from the booking system based on the flight number.
    println("\n--------------------------------Remove Flight Method------------------------------------\n")

    flightBookingSystem.removeFlight(flight4.flightNumber)

    println("\n--------------------------------------------------------------------------------------\n\n")

    // Adding passengers to the booking system

    val passenger1 = Passenger("P1", "Passenger1")
    val passenger2 = Passenger("P2", "Passenger2")
    val passenger3 = Passenger("P3", "Passenger3")


    println("\n--------------------------------Add Passenger Method-----------------------------------\n")

    flightBookingSystem.addPassenger(passenger1)
    flightBookingSystem.addPassenger(passenger2)
    flightBookingSystem.addPassenger(passenger3)

    println("\n-------------------------------------------------------------------------------------\n\n")


    // Removes a passenger from the booking system based on their ID.
    println("\n--------------------------------Remove Passenger by Id Method---------------------------\n")
    flightBookingSystem.removePassengerById(passenger3.id)
    println("\n--------------------------------------------------------------------------------------\n\n")

    // Searches for flights based on the source airport, destination airport, and departure time.
    println("\n----------------------------------Search flight Method----------------------------------\n")
    val searchResult =
        flightBookingSystem.searchFlights("Source1", "Destination1", LocalDateTime.parse("2023-07-05T08:00"))
    if (searchResult.isNotEmpty()) {
        println("Flights found:")
        for (flight in searchResult) {
            println("Flight Number: ${flight.flightNumber}")
            println("Source: ${flight.source}")
            println("Destination: ${flight.destination}")
            println("Departure Time: ${flight.departureTime}")
            println("Arrival Time: ${flight.arrivalTime}\n")
        }
    } else {
        println("No flights found matching the search criteria.")
    }
    flightBookingSystem.searchFlights("Source1", "Destination1", LocalDateTime.parse("2023-07-05T08:00"))
    println("\n--------------------------------------------------------------------------------------\n\n")

    // Booking flights for passengers
    println("\n-----------------------------Book flight for Passenger Method---------------------------\n")
    passenger1.bookFlight(flight1)
    passenger2.bookFlight(flight2)
    passenger3.bookFlight(flight3)
    println("\n--------------------------------------------------------------------------------------\n\n")


    //cancel flight for passengers
    println("\n----------------------------Cancel flight for Passenger Method---------------------------\n")
    passenger3.cancelFlight(flight3.flightNumber)
    println("\n--------------------------------------------------------------------------------------\n\n")


    // Get total travel time
    println("\n----------------------------Total  Travel Time Method---------------------------\n")
    val passengerId = "P1" // Replace with the actual passenger ID
    val passenger = flightBookingSystem.passengers.find { it.id == passengerId }
    if (passenger != null) {
        val totalTravelTime = passenger.getTotalTravelTime()
        val hours = totalTravelTime.toHours()
        val minutes = totalTravelTime.toMinutes() % 60
        println("Total travel time for passenger $passengerId: $hours hours $minutes minutes")

    } else {
        println("Passenger not found.")
    }
    println("\n--------------------------------------------------------------------------------------\n\n")


    // Printing passenger details
    println("\n----------------------------print  passenger details Method---------------------------\n")
    flightBookingSystem.printPassengerDetails("P1")
    flightBookingSystem.printPassengerDetails("P2")
    flightBookingSystem.printPassengerDetails("P3")
    println("\n--------------------------------------------------------------------------------------\n\n")


    // Printing all passengers
    println("\n----------------------------printing all passengers Method---------------------------\n")
    flightBookingSystem.printAllPassengers()
    println("\n--------------------------------------------------------------------------------------\n\n")


    // Printing flight details
    println("\n----------------------------printing flight details Method---------------------------\n")
    flightBookingSystem.printFlightDetails("ABC123")
    flightBookingSystem.printFlightDetails("DEF456")
    flightBookingSystem.printFlightDetails("GHI789")
    println("\n--------------------------------------------------------------------------------------\n\n")


    // Get shortest duration flight
    println("\n----------------------------get shortest flight details Method---------------------------\n")
    val shortestFlight = flightBookingSystem.getShortestFlight(flightBookingSystem.flights)
    if (shortestFlight != null) {
        println("Shortest Flight: ${shortestFlight.flightNumber}")
    } else {
        println("No flights available.")
    }
    println("\n--------------------------------------------------------------------------------------\n\n")


    // Get passenger count by flight
    println("\n----------------------------get passenger count by flight Method---------------------------\n")
    for (flight in flightBookingSystem.flights) {
        val passengerCount = flightBookingSystem.getPassengerCountByFlight(flight.flightNumber)
        println("Flight ${flight.flightNumber}: $passengerCount passengers")
    }
    println("\n--------------------------------------------------------------------------------------\n\n")

    // Process bookings asynchronously
    val bookings = listOf(
        Pair("P1", "DEF456"), Pair("P2", "ABC123"), Pair("P3", "GHI789")
    )
    println("\n-------------------------------process bookings Method-----------------------------------\n")
    runBlocking {
        flightBookingSystem.processBookings(bookings)
    }
    println("\n--------------------------------------------------------------------------------------\n\n")
}


