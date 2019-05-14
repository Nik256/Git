package com.epam.airline.controller;

import com.epam.airline.dto.Crew;
import com.epam.airline.dto.Member;
import com.epam.airline.enums.Position;
import com.epam.airline.enums.Status;
import com.epam.airline.service.CrewService;
import com.epam.airline.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CrewController {

    @Autowired
    private CrewService crewService;

    @Autowired
    private MemberService memberService;

    @GetMapping("/crews")
    private ModelAndView crews() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/crew/crews");
        modelAndView.addObject("crews", crewService.findAll());
        return modelAndView;
    }

    @GetMapping("/crew/{id}")
    private ModelAndView editCrew(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/crew/crew");
        List<Member> members = memberService.getMemberByCrewId(id);
        modelAndView.addObject("pilot", members.stream()
                .filter(m -> m.getPosition() == Position.PILOT)
                .collect(Collectors.toList()));
        modelAndView.addObject("operator", members.stream()
                .filter(m -> m.getPosition() == Position.OPERATOR)
                .collect(Collectors.toList()));
        modelAndView.addObject("navigator", members.stream()
                .filter(m -> m.getPosition() == Position.NAVIGATOR)
                .collect(Collectors.toList()));
        modelAndView.addObject("stewardess", members.stream()
                .filter(m -> m.getPosition() == Position.STEWARDESS)
                .collect(Collectors.toList()));
        modelAndView.addObject("allMembers", memberService.getMemberWithNoCrew());
        modelAndView.addObject("statuses", Status.values());
        modelAndView.addObject("crew", crewService.findById(id));
        return modelAndView;
    }

    @PostMapping("/create-crew")
    private ModelAndView createCrew(@RequestParam(value = "code") String code,
                                    @RequestParam(value = "status") String status,
                                    @RequestParam(value = "member") List<String> memberCodes) {
        Crew crew = crewService.getCrewFromParams(0, code, status, memberCodes);
        crewService.createCrew(crew);
        System.out.println("dsfsdfsd");
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("lksdjfalkdsjflks");
        modelAndView.setViewName("redirect:/crews");
        return modelAndView;
    }

    @GetMapping("/crew")
    private ModelAndView createCrew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("statuses", Status.values());
        modelAndView.addObject("allMembers", memberService.getMemberWithNoCrew());
        modelAndView.setViewName("/crew/new-crew");
        return modelAndView;
    }

    @GetMapping("/delete-crew/{id}")
    private ModelAndView deleteCrew(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        Crew crew = crewService.findById(id);
        crewService.deleteCrew(crew);
        modelAndView.setViewName("redirect:/crews");
        return modelAndView;
    }
}
