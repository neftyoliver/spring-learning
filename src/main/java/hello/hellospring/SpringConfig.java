package hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager entityManager) {
        em = entityManager;
    }

    @Bean
    public /*final*/ MemberService memberService() { // Using final will crash the code witch cannot be overridden.
        MemberRepository memberRepository = memberRepository();

        return new MemberService(memberRepository);
    }

    @Bean
    public MemberRepository memberRepository() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

        //return memoryMemberRepository;
        return new JpaMemberRepository(em);
    }
}
