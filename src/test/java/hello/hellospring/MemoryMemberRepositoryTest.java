package hello.hellospring;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterAll
    public void afterAll() {
        repository.clearAll();
    }

    @Test
    public void save() {
        // 받을 데이터의 예시
        Member member1 = new Member();
        member1.setName("Oliver");

        //언제 데이터를 처리하는가
        repository.save(member1);

        //어떻게 데이터를 처리하는가
        Member result = repository.findByID(member1.getId()).get();
        Assertions.assertEquals(result, member1);
    }

    @Test
    public void findByName() {
        // 받을 데이터
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        // 언제 처리할것인가
        Member result = repository.findByName("spring1").get();

        // 결과
        Assertions.assertEquals(result, member1);
    }

    @Test
    public void findAll() {
        // 받을 데이터
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 언제 처리할것인가
        List<Member> result = repository.findAll();

        // 결과
        assertThat(result.size()).isEqualTo(2);
    }
}
