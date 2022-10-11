package com.jcw.test.service;

import com.jcw.test.entity.Member;
import com.jcw.test.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void joinMember(Member member){
        member.setRole("USER");
        memberRepository.save(member);
//    MemberRepository가 JpaRepository 인터페이스를 상속받으며 기본으로 findBy, save, delete 등의 메소드들을 이용할 수 있다.
    }
}
