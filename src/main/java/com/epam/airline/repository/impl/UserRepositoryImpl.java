package com.epam.airline.repository.impl;

import com.epam.airline.dto.User;
import com.epam.airline.enums.Role;
import com.epam.airline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (login, password, role, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                user.getLogin(),
                user.getPassword(),
                Role.DISPATCHER.toString(),
                user.getFirstName(),
                user.getLastName());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET login = ?, password = ?, first_name = ?, last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getId());
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    @Override
    public User findById(long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User findByLogin(String login) {
        String sql = "SELECT * FROM user WHERE login = ?";
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, login);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<User> findByRole(Role role) {
        String sql = "SELECT * FROM user WHERE role = ?";
        return jdbcTemplate.query(sql, rowMapper, role.toString());
    }
}
