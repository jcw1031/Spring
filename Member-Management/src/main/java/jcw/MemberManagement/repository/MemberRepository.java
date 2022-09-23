package jcw.MemberManagement.repository;

import jcw.MemberManagement.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장하면 저장한 회원 반환
    Optional<Member> findById(Long id); //id로 회원 찾기
    Optional<Member> findByName(String name); //이름으로 회원 찾기

    /* Optional : null을 처리할 때 감싸서 반환하는 법(나중에 자세히)*/
    List<Member> findAll(); //저장된 모든 회원 반환
}
