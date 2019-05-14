package com.epam.airline.repository;

import com.epam.airline.dto.Member;
import com.epam.airline.enums.Position;

import java.util.List;

public interface MemberRepository {

    Member findById(long id);

    Member findByCode(String code);

    void deleteById(long id);

    void save(Member member);

    void update(Member member);

    List<Member> findMemberWithNoCrew();

    List<Member> findMemberByCrew(long crewId);

    List<Member> findAll();

    List<Member> findByCrewAndPosition(long crewId, Position position);
}
