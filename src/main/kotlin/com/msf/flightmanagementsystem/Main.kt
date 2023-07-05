package com.msf.flightmanagementsystem

import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.util.*

fun main() {

    val flightBookingSystem = FlightBookingSystem()
    val scanner = Scanner(System.`in`)
    var exit = false

    while (!exit) {
        println("-----Flight Management System Menu-----")
        println("1.Add Flight")
        println("2.Remove Flight")
        println("3.Add Passenger")
        println("4.Remove Passenger")
        println("5.Search Flight")
        println("6.Book Flight")
        println("7.Cancel Flight")
        println("8.Total Travel Time")
        println("9.Printing Passenger Details")
        println("10.Printing All Passenger Details")
        println("11.Printing Flight Details")
        println("12.Getting Shortest Flight Details")
        println("13.Get Passenger Count by Flight")
        println("14.Process Bookings")
        println("0.Exit")
        println("Enter Your Choice")
        val choice = scanner.nextInt()
        when (choice) {
            1 -> {
                println("Enter how many flights you are going to add")
                val count = scanner.nextInt()
                for (i in 1..count) {
                    println("Enter flight number: ")
                    val flightNumber = scanner.next()
                    println("Enter source: ")
                    val source = scanner.next()
                    println("Enter destination: ")
                    val destination = scanner.next()
                    println("Enter departure time (yyyy-MM-ddTHH:mm): ")
                    val departureTime = LocalDateTime.parse(scanner.next())
                    println("Enter arrival time (yyyy-MM-ddTHH:mm): ")
                    val arrivalTime = LocalDateTime.parse(scanner.next())

                    val flight = Flight(flightNumber, source, destination, departureTime, arrivalTime)
                    flightBookingSystem.addFlight(flight)
                }
            }

            2 -> {
                println("Enter Flight Number: ")
                val flightNumber = scanner.next()
                flightBookingSystem.removeFlight(flightNumber)
            }

            3 -> {
                println("Enter how many passengers you are going to add: ")
                val count = scanner.nextInt()
                for (i in 1..count) {
                    println("Enter passenger id: ")
                    val passengerId = scanner.next()
                    println("Enter passenger name: ")
                    val passengerName = scanner.next()
                    val passenger = Passenger(passengerId, passengerName)
                    flightBookingSystem.addPassenger(passenger)
                }
            }

            4 -> {
                println("Enter passenger id you are going to remove: ")
                val passengerId = scanner.next()
                flightBookingSystem.removePassengerById(passengerId)

            }

            5 -> {
                println("Enter source: ")
                val source = scanner.next()
                println("Enter destination: ")
                val destination = scanner.next()
                println("Enter departure time (yyyy-MM-ddTHH:mm): ")
                val departureTime = LocalDateTime.parse(scanner.next())

                val flights = flightBookingSystem.searchFlights(source, destination, departureTime)
                if (flights.isNotEmpty()) {
                    println("Flight found:")
                    for (flight in flights) {
                        println("Flight Number: ${flight.flightNumber}")
                        println("Source: ${flight.source}")
                        println("Destination: ${flight.destination}")
                        println("Departure Time: ${flight.departureTime}")
                        println("Arrival Time: ${flight.arrivalTime}\n")
                    }
                } else {
                    println("No flights found matching the search criteria.")
                }
            }

            6 -> {
                println("Enter passenger ID: ")
                val passengerId = scanner.next()
                println("Enter flight number: ")
                val flightNumber = scanner.next()

                val passenger = flightBookingSystem.passengers.find { it.id == passengerId }
                val flight = flightBookingSystem.flights.find { it.flightNumber == flightNumber }

                if (passenger != null && flight != null) {
                    passenger.bookFlight(flight)
                } else {
                    println("Passenger or flight not found.")
                }
            }

            7 -> {
                println("Enter passenger ID: ")
                val passengerId = scanner.next()
                println("Enter flight number: ")
                val flightNumber = scanner.next()
                val passenger = flightBookingSystem.passengers.find { it.id == passengerId }
                val flight = flightBookingSystem.flights.find { it.flightNumber == flightNumber }
                if (passenger != null && flight != null) {
                    passenger.cancelFlight(flight.flightNumber)
                    println("Flight cancelled successfully.")
                } else {
                    println("Passenger or flight not found.")
                }

            }

            8 -> {
                println("Enter passenger ID: ")
                val passengerId = scanner.next()

                val passenger = flightBookingSystem.passengers.find { it.id == passengerId }

                if (passenger != null) {
                    val totalTravelTime = passenger.getTotalTravelTime()
                    val hours = totalTravelTime.toHours()
                    val minutes = totalTravelTime.toMinutes() % 60
                    println("Total travel time for passenger $passengerId: $hours hours $minutes minutes")
                } else {
                    println("Passenger not found.")
                }
            }

            9 -> {
                println("Enter passenger ID: ")
                val passengerId = scanner.next()
                flightBookingSystem.printPassengerDetails(passengerId)

            }

            10 -> {
                flightBookingSystem.printAllPassengers()
            }

            11 -> {
                println("Enter flight number: ")
                val flightNumber = scanner.next()
                flightBookingSystem.printFlightDetails(flightNumber)

            }

            12 -> {
                val shortestFlight = flightBookingSystem.getShortestFlight(flightBookingSystem.flights)
                if (shortestFlight != null) {
                    println("Shortest Flight Details:")
                    println("Flight Number: ${shortestFlight.flightNumber}")
                    println("Source: ${shortestFlight.source}")
                    println("Destination: ${shortestFlight.destination}")
                    println("Departure Time: ${shortestFlight.departureTime}")
                    println("Arrival Time: ${shortestFlight.arrivalTime}")
                } else {
                    println("No flights found.")
                }
            }

            13 -> {
                println("Enter flight number: ")
                val flightNumber = scanner.next()
                val passengerCount = flightBookingSystem.getPassengerCountByFlight(flightNumber)
                println("Passenger count for flight $flightNumber: $passengerCount")
            }

            14 -> {
                println("Enter the number of bookings to process: ")
                val count = scanner.nextInt()
                val dynamicBookings = mutableListOf<Pair<String, String>>()
                for (i in 1..count) {
                    println("Enter passenger ID for booking $i: ")
                    val passengerId = scanner.next()
                    println("Enter flight number for booking $i: ")
                    val flightNumber = scanner.next()
                    dynamicBookings.add(Pair(passengerId, flightNumber))
                }
                println("Processing bookings...")
                runBlocking {
                    flightBookingSystem.processBookings(dynamicBookings)
                    println("Bookings processed successfully.")
                }
            }

            0 -> {
                println("Exiting..")
                exit = true
            }

            else -> {
                println("Invalid Choice Please try Again..")
            }
        }
    }
}


