package ru.onuchin.MTS.App.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.onuchin.MTS.App.model.Reading;

import java.sql.Timestamp;
import java.time.Instant;

@Repository
public class ReadingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReadingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void postReadings(int value) {
        jdbcTemplate.update("INSERT INTO readings (ts, value) VALUES (?, ?)",
                Timestamp.from(Instant.now()), value);
    }

    public Reading getReading() {
        String sql = "SELECT * FROM readings ORDER BY ts DESC LIMIT 1";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Reading.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
