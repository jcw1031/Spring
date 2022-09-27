package jcw.MemberManagement;

import jcw.MemberManagement.repository.JdbcTemplateMemberRepository;
import jcw.MemberManagement.repository.MemberRepository;
import jcw.MemberManagement.repository.MemoryMemberRepository;
import jcw.MemberManagement.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource; //데이터베이스 커넥션을 획득할 때 사용하는 객체

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean //스프링 빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean //스프링 빈에 등록
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
