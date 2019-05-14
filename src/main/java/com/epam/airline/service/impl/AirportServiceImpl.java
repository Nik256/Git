package com.epam.airline.service.impl;

import com.epam.airline.dto.Airport;
import com.epam.airline.repository.AirportRepository;
import com.epam.airline.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }
}
