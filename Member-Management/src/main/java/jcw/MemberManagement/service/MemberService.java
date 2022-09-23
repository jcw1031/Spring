package jcw.MemberManagement.service;

import jcw.MemberManagement.domain.Member;
import jcw.MemberManagement.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    /*private final MemberRepository memberRepository = new MemoryMemberRepository();
        -> 테스트케이스에서 다른 memberRepository로 하게 되는 것이기 때문에 아래처럼*/

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) { //Dependency Injection(DI)
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * @param member
     * @return Long
     */
    public Long join(Member member){
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */

        //위의 코드도 가능하지만 아래가 깔끔하게 가능

        validateDuplicatieMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    /**같은 이름의 중복 회원이 가입되는 것 금지
     *
     * @param member
     */
    private void validateDuplicatieMember(Member member) {
        memberRepository.findByName(member.getName()) //null이 아니라 값이 있으면 로직이 동작 (Optional이기 때문에 가능)
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /** 전체 회원 조회
     *
     * @return List
     */
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    /** id를 통해 회원 조회
     *
     * @param memberId
     * @return Optional
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
