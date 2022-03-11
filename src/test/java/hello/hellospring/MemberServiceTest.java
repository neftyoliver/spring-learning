package hello.hellospring;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterAll
    public void afterAll() {
        memberRepository.clearAll();
    }

    @Test
    void 회원가입() { // 테스트는 한글로 작성할 수도 있다!
        // give
        Member member = new Member();
        member.setName("hello");

        // when
        Long savedId = memberService.join(member);

        // then
        Member findedMember = memberService.findOne(savedId).get();
        assertEquals(findedMember, member);
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // then
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertEquals(e.getMessage(), "이미 존재하는 회원입니다.");

        /* 이렇게 안해도 된다!
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다");
        } catch(IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/
        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
