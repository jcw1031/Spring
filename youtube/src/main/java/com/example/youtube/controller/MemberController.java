package com.example.youtube.controller;

import com.example.youtube.entity.Member;
import com.example.youtube.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    /*@PostConstruct //스프링이 Member 객체를 만든 직후 실행하는 메소드의 어노테이션 (데이터 초기화가 가능)
    public void init() {
        memberService = new MemberService();
    }*/

    /*@GetMapping("/user/{id}") //
    public Member getUserProfile(@PathVariable("id") String id) {
        //path안에 {} 사이에 있는 id를 path variable로 인식하고 String id 파라미터로 임명하여 API 호출

        Member member = memberService.findById(id);
        return member;
    }

    @GetMapping("/user/all")
    public List<Member> getUserProfileList(){
        List<Member> list = memberService.findAll();
        return list;
    }*/

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        Member member = memberService.setProfile(id, name, phone, address);
        memberService.join(member);
    }
}