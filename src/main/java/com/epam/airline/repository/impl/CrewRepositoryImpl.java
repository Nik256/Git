package com.epam.airline.repository.impl;

import com.epam.airline.dto.Crew;
import com.epam.airline.dto.Member;
import com.epam.airline.enums.Status;
import com.epam.airline.repository.CrewRepository;
import com.epam.airline.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrewRepositoryImpl implements CrewRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    MemberRepository memberRepository;

    private RowMapper<Crew> rowMapper = (rs, rowNum) -> new Crew(
            rs.getLong("id"),
            rs.getString("code"),
            Status.valueOf(rs.getString("status")),
            memberRepository.findMemberByCrew(rs.getLong("id")));

    @Override
    public Crew findById(long id) {
        String sql = "SELECT * FROM crew WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Crew findByCode(String code) {
        String sql = "SELECT * FROM crew WHERE code = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, code);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Crew> findAll() {
        String sql = "SELECT * FROM crew";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Crew> findByStatus(Status status) {
        String sql = "SELECT * FROM crew WHERE status = ?";
        return jdbcTemplate.query(sql, rowMapper, status.toString());
    }

    @Override
    public void save(Crew crew) {
        String sql = "INSERT INTO crew (code, status) VALUES (?, ?)";
        jdbcTemplate.update(sql,
                crew.getCode(),
                crew.getStatus().toString());
        for (Member member : crew.getMembers()) {
            member.setCrew(findByCode(crew.getCode()).getId());
            memberRepository.update(member);
        }
    }

    @Override
    public void update(Crew crew) {
        String sql = "UPDATE crew SET code = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                crew.getCode(),
                crew.getStatus().toString(),
                crew.getId());
        for (Member member : crew.getMembers()) {
            member.setCrew(crew.getId());
            memberRepository.update(member);
        }
    }

    @Override
    public void delete(Crew crew) {
        String sql = "DELETE FROM crew WHERE id = ?";
        jdbcTemplate.update(sql, crew.getId());
        for (Member member : crew.getMembers()) {
            member.setCrew(-1);
            memberRepository.update(member);
        }
    }
}
