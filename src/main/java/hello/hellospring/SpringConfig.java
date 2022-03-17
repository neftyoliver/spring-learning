package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SpringConfig {

    //@Bean
    public /*final*/ MemberService memberService() { // Using final will crash the code witch cannot be overridden.
        MemberRepository memberRepository = memberRepository();

        return new MemberService(null);
    }

    //@Bean
    public MemberRepository memberRepository() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

        return memoryMemberRepository;
    }
}
