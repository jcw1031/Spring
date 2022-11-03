package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional //EntityManager를 통한 모든 데이터 변경은 항상 transaction 안에서 이루어져야 한다. (test에 있으면 test가 끝난 후 DB 롤백)
//    @Rollback(false) //test가 끝나도 롤백을 하지 않는다.
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUserName("member A");
        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
        Assertions.assertThat(findMember).isEqualTo(member);
        //같은 transaction 안에서 저장하고 조회하면 영속성 컨텍스트가 같기 때문에 true
    }
}
