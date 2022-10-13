package com.example.youtube.service;

import com.example.youtube.entity.Member;
import com.example.youtube.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService{

    @Autowired
    MemberRepository memberRepository;

    /*public MemberService() {
        this.memberRepository = new MemoryMemberRepository();
    }*/

    /*public Member join(Member member) {
        Member search = memberRepository.findById(member.getMemberId());
        if (search == null) {
            memberRepository.save(member);
            return member;
        } else {
            System.out.println("이미 존재하는 아이디입니다.");
            return null;
        }
    }

    public Member findById(String id) {
        Member member = memberRepository.findById(id);
        return member;
    }

    public Member findByName(String name) {
        Member member = memberRepository.findByName(name);
        return member;
    }

    public List<Member> findAll(){
        List<Member> list = memberRepository.findAll();
        return list;
    }*/

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member setProfile(String id, String name, String phone, String address) {
        Member member = new Member();
        member.setMemberId(id);
        member.setMemberName(name);
        member.setMemberPhone(phone);
        member.setMemberAddress(address);
        return member;
    }
}