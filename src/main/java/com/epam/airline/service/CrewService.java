package com.epam.airline.service;

import com.epam.airline.dto.Crew;

import java.util.List;

public interface CrewService {

    Crew findById(long id);

    List<Crew> findAll();

    List<Crew> getReadyCrew();

    void createCrew(Crew crew);

    void editCrew(Crew crew);

    void deleteCrew(Crew crew);

    void editPreviousMember(long crewId);

    Crew getCrewFromParams(long id, String code, String status, List<String> memberCodes);
}
