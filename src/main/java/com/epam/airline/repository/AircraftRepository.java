package com.epam.airline.repository;

import com.epam.airline.dto.Aircraft;

import java.util.List;

public interface AircraftRepository {

    Aircraft findById(long id);

    Aircraft findByTailNumber(String tailNumber);

    List<Aircraft> findAll();
}
