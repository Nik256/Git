package com.epam.airline.service;

import com.epam.airline.dto.Aircraft;

import java.util.List;

public interface AircraftService {

    List<Aircraft> findAll();
}
