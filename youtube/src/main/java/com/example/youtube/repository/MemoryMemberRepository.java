/*
package com.example.youtube.repository;

import com.example.youtube.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class MemoryMemberRepository implements MemberRepository {
    private Map<String, Member> memory;

    */
/*@PostConstruct
    public void init() {
        memory = new HashMap<>();
        memory.put("1", new Member("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
        memory.put("2", new Member("2", "홍길자", "222-2222", "서울시 강남구 대치2동"));
        memory.put("3", new Member("3", "홍길순", "333-3333", "서울시 강남구 대치3동"));
    }*//*


    public MemoryMemberRepository() {
        this.memory = new HashMap<>();
        memory.put("1", new Member("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
        memory.put("2", new Member("2", "홍길자", "222-2222", "서울시 강남구 대치2동"));
        memory.put("3", new Member("3", "홍길순", "333-3333", "서울시 강남구 대치3동"));
    }

    @Override
    public Member save(Member member){
        memory.put(member.getMemberId(), member);
        return member;
    }

    @Override
    public Member findById(String id) {
        Member member = memory.get(id);
        return member;
    }

    @Override
    public Member findByName(String name){
        Member member;
        for (String key : memory.keySet()) {
            member = memory.get(key);
            if(member.getMemberName().equals(name)){
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Member> findAll(){
        List<Member> list = new ArrayList<>();
        for (String key : memory.keySet()) {
            list.add(memory.get(key));
        }
        return list;
    }
}
*/
