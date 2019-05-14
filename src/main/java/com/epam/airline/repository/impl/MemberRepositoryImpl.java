package com.epam.airline.repository.impl;

import com.epam.airline.dto.Member;
import com.epam.airline.enums.Position;
import com.epam.airline.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<Member> rowMapper = (rs, rowNum) -> new Member(
            rs.getLong("id"),
            rs.getString("code"),
            Position.valueOf(rs.getString("position")),
            rs.getString("name"),
            rs.getString("surname"),
            rs.getLong("crew"));

    @Override
    public Member findById(long id) {
        String sql = "SELECT * FROM member WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Member findByCode(String code) {
        String sql = "SELECT * FROM member WHERE code = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, code);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM member WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void save(Member member) {
        String sql = "INSERT INTO member (code, position, name, surname, crew) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                member.getCode(),
                member.getPosition().toString(),
                member.getName(),
                member.getSurname(),
                member.getCrew());
    }

    @Override
    public void update(Member member) {
        String sql = "UPDATE member SET code = ?, position = ?, name = ?, surname = ?, crew = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                member.getCode(),
                member.getPosition().toString(),
                member.getName(),
                member.getSurname(),
                member.getCrew(),
                member.getId());
    }

    @Override
    public List<Member> findMemberWithNoCrew() {
        String sql = "SELECT * FROM member WHERE crew = -1";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Member> findMemberByCrew(long crewId) {
        String sql = "SELECT * FROM member WHERE crew = ?";
        return jdbcTemplate.query(sql, rowMapper, crewId);
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM member";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Member> findByCrewAndPosition(long crewId, Position position) {
        String sql = "SELECT * FROM member WHERE crew = ? AND position = ?";
        return jdbcTemplate.query(sql, rowMapper, crewId, position.toString());
    }
}
