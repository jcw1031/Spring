package com.example.youtube.service;

import com.example.youtube.entity.Member;
import com.example.youtube.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService{

    @Autowired
    MemberRepository memberRepository;

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

    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByName(String name) {
        return memberRepository.findByMemberName(name);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void leave(Member member) {
        memberRepository.delete(member);
    }

    public void clearAll() {
        memberRepository.deleteAll();
    }
}