package com.epam.airline.service;

import com.epam.airline.dto.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    void createFlight(Flight flight);

    List<Flight> findAll();

    Flight getFlightFromParams(long id,
                               String code,
                               String aircraft,
                               String fromAirport,
                               String toAirport,
                               LocalDateTime departureDateTime,
                               LocalDateTime arrivalDateTime,
                               String crew,
                               String status);

    void editFlight(Flight flight);

    void deleteFlight(Flight flight);

    Flight getFlightById(long id);
}
