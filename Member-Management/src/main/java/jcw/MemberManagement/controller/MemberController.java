package jcw.MemberManagement.controller;

import jcw.MemberManagement.domain.Member;
import jcw.MemberManagement.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller //객체를 생성하여 스프링이 갖고있는다. (스프링 빈이 관리된다고 표현)
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링이 스프링 컨테이너에 있는 memberService를 가져와 연결해준다.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //@GetMapping : 보통 조회할 때 사용
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //@PostMapping : 보통 데이터를 form같은 곳에 넣어서 전달할 때 사용
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());
        
        memberService.join(member);

        return "redirect:/";
    }
}
