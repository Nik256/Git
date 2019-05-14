package com.epam.airline.repository.impl;

import com.epam.airline.dto.Aircraft;
import com.epam.airline.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AircraftRepositoryImpl implements AircraftRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Aircraft> rowMapper = new BeanPropertyRowMapper<>(Aircraft.class);

    @Override
    public Aircraft findById(long id) {
        String sql = "SELECT * FROM aircraft WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Aircraft findByTailNumber(String tailNumber) {
        String sql = "SELECT * FROM aircraft WHERE tail_number = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, tailNumber);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Aircraft> findAll() {
        String sql = "SELECT * FROM aircraft";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
