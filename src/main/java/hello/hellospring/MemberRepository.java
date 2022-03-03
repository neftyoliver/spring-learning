package hello.hellospring;

import java.util.*;

public interface MemberRepository {
    Member save(Member pMember);
    Optional<Member> findByID(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
