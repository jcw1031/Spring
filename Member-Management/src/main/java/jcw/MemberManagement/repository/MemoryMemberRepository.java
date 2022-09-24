package jcw.MemberManagement.repository;

import jcw.MemberManagement.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository //스프링 빈으로 관리하도 설정
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //store.get(id)가 null 이어도 감쌀 수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //람다식 이용. 하나라도 찾으면 return. 끝까지 없으면 null return
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
