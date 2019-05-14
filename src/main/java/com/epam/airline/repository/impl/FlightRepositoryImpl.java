package com.epam.airline.repository.impl;

import com.epam.airline.dto.Flight;
import com.epam.airline.enums.Status;
import com.epam.airline.repository.AircraftRepository;
import com.epam.airline.repository.AirportRepository;
import com.epam.airline.repository.CrewRepository;
import com.epam.airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightRepositoryImpl implements FlightRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private CrewRepository crewRepository;

    private RowMapper<Flight> rowMapper = (rs, rowNum) -> new Flight(
            rs.getLong("id"),
            rs.getString("code"),
            aircraftRepository.findById(rs.getLong("aircraft")),
            airportRepository.findById(rs.getLong("from_airport")),
            airportRepository.findById(rs.getLong("to_airport")),
            rs.getTimestamp("departure_datetime").toLocalDateTime(),
            rs.getTimestamp("arrival_datetime").toLocalDateTime(),
            crewRepository.findById(rs.getLong("crew")),
            Status.valueOf(rs.getString("status")));

    @Override
    public void save(Flight flight) {
        String sql = "INSERT INTO flight (code, aircraft, from_airport, to_airport, departure_datetime, arrival_datetime, " +
                "crew, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                flight.getCode(),
                flight.getAircraft().getId(),
                flight.getFromAirport().getId(),
                flight.getToAirport().getId(),
                flight.getDepartureDateTime(),
                flight.getArrivalDateTime(),
                flight.getCrew().getId(),
                flight.getStatus().toString());
    }

    @Override
    public Flight findById(long id) {
        String sql = "SELECT * FROM flight WHERE id = ?";
        try {
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Flight flight) {
        String sql = "UPDATE flight SET code = ?, aircraft = ?, from_airport = ?, to_airport = ?, departure_datetime = ?, " +
                "arrival_datetime = ?, crew = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                flight.getCode(),
                flight.getAircraft().getId(),
                flight.getFromAirport().getId(),
                flight.getToAirport().getId(),
                flight.getDepartureDateTime(),
                flight.getArrivalDateTime(),
                flight.getCrew().getId(),
                flight.getStatus().toString(),
                flight.getId());
    }

    @Override
    public List<Flight> findAll() {
        String sql = "SELECT * FROM flight";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM flight WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
