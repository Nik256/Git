package com.epam.airline.service.impl;

import com.epam.airline.dto.Crew;
import com.epam.airline.dto.Member;
import com.epam.airline.enums.Status;
import com.epam.airline.repository.CrewRepository;
import com.epam.airline.repository.MemberRepository;
import com.epam.airline.service.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrewServiceImpl implements CrewService {

    @Autowired
    private CrewRepository crewRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Crew findById(long id) {
        return crewRepository.findById(id);
    }

    @Override
    public List<Crew> findAll() {
        return crewRepository.findAll();
    }

    @Override
    public List<Crew> getReadyCrew() {
        return crewRepository.findByStatus(Status.READY);
    }

    @Override
    public void createCrew(Crew crew) {
        if (crew.getMembers().size() != 8) {
            crew.setStatus(Status.WAITING_FOR_APPROVAL);
        }
        crewRepository.save(crew);
    }

    @Override
    public void editCrew(Crew crew) {
        if (crew.getMembers().size() != 8) {
            crew.setStatus(Status.WAITING_FOR_APPROVAL);
        }
        crewRepository.update(crew);
    }

    @Override
    public void deleteCrew(Crew crew) {
        crewRepository.delete(crew);
    }

    @Override
    public Crew getCrewFromParams(long id, String code, String status, List<String> memberCodes) {
        List<Member> members = new ArrayList<>();
        for (String member : memberCodes) {
            if (!member.equals(""))
                members.add(memberRepository.findByCode(member.split(" ")[0]));
        }
        Crew crew = new Crew(id, code, Status.get(status), members);
        return crew;
    }

    @Override
    public void editPreviousMember(long crewId) {
        for (Member member : memberRepository.findMemberByCrew(crewId)) {
            member.setCrew(-1);
            memberRepository.update(member);
        }
    }
}

