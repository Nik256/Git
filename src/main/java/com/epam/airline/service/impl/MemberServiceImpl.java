package com.epam.airline.service.impl;

import com.epam.airline.dto.Member;
import com.epam.airline.enums.Position;
import com.epam.airline.exception.CrewSelectException;
import com.epam.airline.repository.CrewRepository;
import com.epam.airline.repository.MemberRepository;
import com.epam.airline.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CrewRepository crewRepository;

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> getMemberByCrewId(long crewId) {
        return memberRepository.findMemberByCrew(crewId);
    }

    @Override
    public List<Member> getMemberWithNoCrew() {
        return memberRepository.findMemberWithNoCrew();
    }

    @Override
    public void createMember(Member member) {
        if (isValidMember(member))
            memberRepository.save(member);
    }

    @Override
    public void editMember(Member member) {
        if (isValidMember(member))
            memberRepository.update(member);
    }

    @Override
    public void deleteMember(Member member) {
        memberRepository.deleteById(member.getId());
    }

    @Override
    public Member getMemberFromParams(long id, String code, String position, String name, String surname, String crewCode) {
        long crewId = -1;
        if (!crewCode.equals(""))
            crewId = crewRepository.findByCode(crewCode).getId();
        Member member = new Member(id, code, Position.get(position), name, surname, crewId);
        return member;
    }

    @Override
    public List<Member> getMembersByCrewAndPosition(long crewId, Position position) {
        return memberRepository.findByCrewAndPosition(crewId, position);
    }

    @Override
    public Boolean isValidMember(Member member) {
        List<Member> members = getMembersByCrewAndPosition(member.getCrew(), member.getPosition());
        for (Member tempMember : members) {
            if(tempMember.getCode().equals(member.getCode()))
                return true;
        }
        if (members == null ||
                (members.size() == 2 && member.getPosition() == Position.PILOT) ||
                (members.size() == 1 && member.getPosition() == Position.NAVIGATOR) ||
                (members.size() == 1 && member.getPosition() == Position.OPERATOR) ||
                (members.size() == 4 && member.getPosition() == Position.STEWARDESS)) {
            throw new CrewSelectException("Выбран экипаж с уже полным составом по выбранной должности");
        }
        return true;
    }
}
