package com.jcw.test.controller;

import com.jcw.test.entity.Member;
import com.jcw.test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "joinUs.do", method = RequestMethod.POST)
    public String joinUs(Member member){
        memberService.joinMember(member);
        return "join";
    }
}