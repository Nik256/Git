package com.epam.airline.service.impl;

import com.epam.airline.dto.Flight;
import com.epam.airline.enums.Status;
import com.epam.airline.exception.IncorrectAirportException;
import com.epam.airline.exception.IncorrectDateTimeException;
import com.epam.airline.repository.AircraftRepository;
import com.epam.airline.repository.AirportRepository;
import com.epam.airline.repository.CrewRepository;
import com.epam.airline.repository.FlightRepository;
import com.epam.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private CrewRepository crewRepository;

    @Override
    public void createFlight(Flight flight) {
        validateFlight(flight);
        flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightFromParams(long id,
                                      String code,
                                      String aircraft,
                                      String fromAirport,
                                      String toAirport,
                                      LocalDateTime departureDateTime,
                                      LocalDateTime arrivalDateTime,
                                      String crew,
                                      String status) {
        Flight flight = new Flight(id,
                code,
                aircraftRepository.findByTailNumber(aircraft),
                airportRepository.findByName(fromAirport),
                airportRepository.findByName(toAirport),
                departureDateTime,
                arrivalDateTime,
                crewRepository.findByCode(crew),
                Status.get(status));
        return flight;
    }

    @Override
    public void editFlight(Flight flight) {
        validateFlight(flight);
        flightRepository.update(flight);
    }

    @Override
    public void deleteFlight(Flight flight) {
        flightRepository.deleteById(flight.getId());
    }

    @Override
    public Flight getFlightById(long id) {
        return flightRepository.findById(id);
    }

    public void validateFlight(Flight flight) {
        if(flight.getFromAirport().getCode().equals(flight.getToAirport().getCode())) {
            throw new IncorrectAirportException("Выбран один и тот же аэропорт");
        }
        if(flight.getDepartureDateTime().compareTo(flight.getArrivalDateTime()) >= 0 ||
                flight.getDepartureDateTime().compareTo(LocalDateTime.now()) <= 0 ||
                flight.getArrivalDateTime().compareTo(LocalDateTime.now()) <= 0)
            throw new IncorrectDateTimeException("Выбрана неправильная дата/время");
    }
}
