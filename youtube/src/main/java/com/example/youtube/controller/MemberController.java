package com.example.youtube.controller;

import com.example.youtube.entity.Member;
import com.example.youtube.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 회원가입
     * @param id String
     * @param name String
     * @param phone String
     * @param address String
     */
    /*@PostMapping("/user/signup/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        Optional<Member> duplicate = memberService.findById(id);
        if (duplicate.isEmpty()) {
            Member member = memberService.setProfile(id, name, phone, address);
            System.out.println(member.getMemberId());
            memberService.join(member);
        } else {
            System.out.println("이미 존재하는 아이디입니다.");
        }
    }*/

    @PostMapping("/user/signup")
    public void postUserProfile(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        Optional<Member> duplicate = memberService.findById(id);
        if (duplicate.isEmpty()) {
            Member member = memberService.setProfile(id, name, phone, address);
            System.out.println(member.getMemberId());
            memberService.join(member);
        } else {
            System.out.println("이미 존재하는 아이디입니다.");
        }
    }

    /**
     * id로 사용자 검색
     * @param id
     * @return
     */
    @GetMapping("/user/search//id/{id}")
    public Optional<Member> getUserProfileById(@PathVariable("id") String id) {
        Optional<Member> member = memberService.findById(id);
        return member;
    }

    /**
     * 이름으로 사용자 검색
     * @param name
     * @return
     */
    @GetMapping("/user/search/name/{name}")
    public Optional<Member> getUserProfileByName(@PathVariable("name") String name) {
        Optional<Member> member = memberService.findByName(name);
        if(member.isPresent()) {
            return member;
        }
        else{
            System.out.println("'"+name+"' 이름의 회원이 존재하지 않습니다.");
        }
        return Optional.empty();
    }

    /**
     * 모든 사용자 검색
     * @return
     */
    @GetMapping("/user/search/all")
    public List<Member> getUserProfileList() {
        List<Member> list = memberService.findAll();
        return list;
    }

    /**
     * 회원 정보 수정
     * @param id String
     * @param name String
     * @param phone String
     * @param address String
     */
    @PutMapping("/user/update/{id}")
    public void updateUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
        Optional<Member> optionalMember = memberService.findById(id);
        optionalMember.get().setMemberName(name);
        optionalMember.get().setMemberPhone(phone);
        optionalMember.get().setMemberAddress(address);
        memberService.join(optionalMember.get());
    }

    /**
     * 회원 탈퇴
     * @param id
     */
    @DeleteMapping("/user/delete/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        Optional<Member> member = memberService.findById(id);
        if(member.isPresent()){
            memberService.leave(member.get());
        }
        else{
            System.out.println("존재하지 않는 아이디입니다.");
        }
    }
}