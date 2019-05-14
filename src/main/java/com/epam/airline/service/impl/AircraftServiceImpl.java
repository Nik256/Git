package com.epam.airline.service.impl;

import com.epam.airline.dto.Aircraft;
import com.epam.airline.repository.AircraftRepository;
import com.epam.airline.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }
}
