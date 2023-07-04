/*

fun main() {
    // Create flights
    val flight1 = Flight("ABC123", "Airport1", "Airport2",
        LocalDateTime.parse("2023-06-28T10:00:00"), LocalDateTime.parse("2023-06-28T12:00:00"))
    val flight2 = Flight("DEF456", "Airport2", "Airport3",
        LocalDateTime.parse("2023-06-28T13:00:00"), LocalDateTime.parse("2023-06-28T15:00:00"))

    // Create passenger
    val passenger = Passenger("P001", "John Doe")

    // Book flights for the passenger
    passenger.bookFlight(flight1)
    passenger.bookFlight(flight2)

    // Print the passenger's booked flights
    println("Passenger: ${passenger.getName()}")
    println("Booked Flights:")
    for (flight in passenger.flights) {
        println("Flight Number: ${flight.getFlightNumber()}")
        println("Source: ${flight.getSource()}")
        println("Destination: ${flight.getDestination()}")
        println("Departure Time: ${flight.getDepartureTime()}")
        println("Arrival Time: ${flight.getArrivalTime()}")
        println()
    }

    // Cancel a flight for the passenger
    passenger.cancelFlight("ABC123")

    // Print the updated list of the passenger's booked flights
    println("Updated Booked Flights:")
    for (flight in passenger.flights) {
        println("Flight Number: ${flight.getFlightNumber()}")
        println("Source: ${flight.getSource()}")
        println("Destination: ${flight.getDestination()}")
        println("Departure Time: ${flight.getDepartureTime()}")
        println("Arrival Time: ${flight.getArrivalTime()}")
        println()
    }

    // Calculate and print the total travel time
    val totalTravelTime = passenger.getTotalTravelTime()
    println("Total Travel Time: $totalTravelTime")
}

 */



