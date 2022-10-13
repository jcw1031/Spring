package com.example.youtube.repository;

import com.example.youtube.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    /*public Member save(Member member);

    public Member findById(String id);

    public Member findByName(String name);

    public List<Member> findAll();*/
}
