package com.epam.airline.repository;


import com.epam.airline.dto.Airport;

import java.util.List;

public interface AirportRepository {

    Airport findById(long id);

    Airport findByName(String name);

    List<Airport> findAll();
}