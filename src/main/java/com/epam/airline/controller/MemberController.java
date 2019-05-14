package com.epam.airline.controller;

import com.epam.airline.dto.Member;
import com.epam.airline.enums.Position;
import com.epam.airline.service.CrewService;
import com.epam.airline.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private CrewService crewService;

    @GetMapping("/members")
    private ModelAndView members() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/member/members");
        modelAndView.addObject("members", memberService.findAll());
        return modelAndView;
    }

    @GetMapping("/member/{id}")
    private ModelAndView editMember(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/member/member");
        modelAndView.addObject("positions", Position.values());
        modelAndView.addObject("member", memberService.getMemberById(id));
        modelAndView.addObject("crews", crewService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-member")
    private ModelAndView createMember(@RequestParam(value = "code") String code,
                                      @RequestParam(value = "position") String position,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "surname") String surname,
                                      @RequestParam(value = "crew") String crewCode) {
        Member newMember = memberService.getMemberFromParams(-1, code, position, name, surname, crewCode);
        memberService.createMember(newMember);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/members");
        return modelAndView;
    }

    @PostMapping("/edit-member")
    private ModelAndView editMember(@RequestParam(value = "id") long id,
                                    @RequestParam(value = "code") String code,
                                    @RequestParam(value = "position") String position,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "surname") String surname,
                                    @RequestParam(value = "crew") String crewCode) {
        Member editedMember = memberService.getMemberFromParams(id, code, position, name, surname, crewCode);
        memberService.editMember(editedMember);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/members");
        return modelAndView;
    }

    @GetMapping("/member")
    private ModelAndView createMember() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("positions", Position.values());
        modelAndView.addObject("crews", crewService.findAll());
        modelAndView.setViewName("/member/member");
        return modelAndView;
    }

    @GetMapping("/delete-member/{id}")
    private ModelAndView deleteMember(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        Member memberToDelete = memberService.getMemberById(id);
        memberService.deleteMember(memberToDelete);
        modelAndView.setViewName("redirect:/members");
        return modelAndView;
    }
}
