package com.epam.airline.repository;

import com.epam.airline.dto.Flight;

import java.util.List;

public interface FlightRepository {

    void save(Flight flight);

    Flight findById(long id);

    void update(Flight flight);

    List<Flight> findAll();

    void deleteById(long id);
}
