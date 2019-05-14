package com.epam.airline.repository.impl;

import com.epam.airline.dto.Airport;
import com.epam.airline.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportRepositoryImpl implements AirportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Airport> rowMapper = new BeanPropertyRowMapper<>(Airport.class);

    @Override
    public Airport findById(long id) {
        String sql = "SELECT * FROM airport WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Airport findByName(String name) {
        String sql = "SELECT * FROM airport WHERE name = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Airport> findAll() {
        String sql = "SELECT * FROM airport";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
