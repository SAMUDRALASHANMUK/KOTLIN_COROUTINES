package FLIGHT_MANAGEMENT.COM
class FlightBookingSystem<LocalDateTime> {
    private val flights: MutableList<Flight> = mutableListOf()
    private val passengers: MutableList<Passenger> = mutableListOf()


    fun addFlight(flight: Flight) {
        flights.add(flight)
    }

    fun removeFlight(flightNumber: String) {
        val flightToRemove = flights.find { it.getFlightNumber() == flightNumber }
        flights.remove(flightToRemove)
    }


    fun addPassenger(passenger: Passenger) {
        passengers.add(passenger)
    }

    fun removePassengerById(passengerId: String) {
        val passengerToRemove = passengers.find { it.getId() == passengerId }
        passengers.remove(passengerToRemove)
    }


    fun searchFlights(source: String, destination: String, departureTime: LocalDateTime): List<Flight> {
        return flights.filter { it.getSource() == source && it.getDestination() == destination && it.getDepartureTime() == departureTime }
    }



    fun printPassengerDetails(passengerId: String) {
        val passenger = passengers.find { it.getId() == passengerId }
        if (passenger != null) {
            println("Passenger Details:")
            println("ID: ${passenger.getId()}")
            println("Name: ${passenger.getName()}")
            println("Booked Flights:")
            for (flight in passenger.flights) {
                println("Flight Number: ${flight.getFlightNumber()}")
                println("Source: ${flight.getSource()}")
                println("Destination: ${flight.getDestination()}")
                println("Departure Time: ${flight.getDepartureTime()}")
                println("Arrival Time: ${flight.getArrivalTime()}")
                println()
            }
        } else {
            println("Passenger not found.")
        }
    }

    fun printAllPassengers() {
        if (passengers.isNotEmpty()) {
            println("Passenger Details:")
            for (passenger in passengers) {
                println("ID: ${passenger.getId()}")
                println("Name: ${passenger.getName()}")
                println("Booked Flights:")
                for (flight in passenger.flights) {
                    println("Flight Number: ${flight.getFlightNumber()}")
                    println("Source: ${flight.getSource()}")
                    println("Destination: ${flight.getDestination()}")
                    println("Departure Time: ${flight.getDepartureTime()}")
                    println("Arrival Time: ${flight.getArrivalTime()}")
                    println()
                }
            }
        } else {
            println("No passengers found.")
        }
    }

    fun printFlightDetails(flightNumber: String) {
        val flight = flights.find { it.getFlightNumber() == flightNumber }
        if (flight != null) {
            println("Flight Details:")
            println("Flight Number: ${flight.getFlightNumber()}")
            println("Source: ${flight.getSource()}")
            println("Destination: ${flight.getDestination()}")
            println("Departure Time: ${flight.getDepartureTime()}")
            println("Arrival Time: ${flight.getArrivalTime()}")
        } else {
            println("Flight not found.")
        }
    }
}