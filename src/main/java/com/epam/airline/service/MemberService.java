package com.epam.airline.service;

import com.epam.airline.dto.Member;
import com.epam.airline.enums.Position;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member getMemberById(long id);

    List<Member> getMemberByCrewId(long crewId);

    List<Member> getMemberWithNoCrew();

    void createMember(Member member);

    void editMember(Member member);

    Boolean isValidMember(Member member);

    void deleteMember(Member member);

    List<Member> getMembersByCrewAndPosition(long crewId, Position position);

    Member getMemberFromParams(long id,
                               String code,
                               String position,
                               String name,
                               String surname,
                               String crewCode);
}
