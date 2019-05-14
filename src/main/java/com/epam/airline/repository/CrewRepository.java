package com.epam.airline.repository;

import com.epam.airline.dto.Crew;
import com.epam.airline.enums.Status;

import java.util.List;

public interface CrewRepository {

    Crew findById(long id);

    Crew findByCode(String code);

    List<Crew> findAll();

    List<Crew> findByStatus(Status status);

    void save(Crew crew);

    void update(Crew crew);

    void delete(Crew crew);
}
