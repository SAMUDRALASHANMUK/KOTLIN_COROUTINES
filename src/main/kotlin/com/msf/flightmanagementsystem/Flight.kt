package com.msf.flightmanagementsystem

import java.time.LocalDateTime

// Flight class representing a flight with its properties
class Flight(
    var flightNumber: String,
    var source: String,
    var destination: String,
    var departureTime: LocalDateTime,
    var arrivalTime: LocalDateTime
)


