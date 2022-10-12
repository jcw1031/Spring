package com.example.youtube.repository;

import com.example.youtube.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberRepository {
    public Member save(Member member);
    public Member findById(String id);
    public Member findByName(String name);
    public List<Member> findAll();
}
