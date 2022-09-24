package jcw.MemberManagement.controller;

import jcw.MemberManagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //객체를 생성하여 스프링이 갖고있는다. (스프링 빈이 관리된다고 표현)
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링이 스프링 컨테이너에 있는 memberService를 가져와 연결해준다.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
