package jcw.MemberManagement;

import jcw.MemberManagement.repository.MemberRepository;
import jcw.MemberManagement.repository.MemoryMemberRepository;
import jcw.MemberManagement.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean //스프링 빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean //스프링 빈에 등록
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
