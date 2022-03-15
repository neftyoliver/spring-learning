package hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository pMemberRepository) {
        this.memberRepository = pMemberRepository;
    }

    public Long join(Member pMember) {
        // 중복 불가

        validateDuplicatedMember(pMember);

        this.memberRepository.save(pMember);
        return pMember.getId();
    }

    private void validateDuplicatedMember(Member pMember) {
        memberRepository.findByName(pMember.getName()).ifPresent(actionMember -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {
        return this.memberRepository.findAll();
    }

    public Optional<Member> findOne(Long Id) {
        return this.memberRepository.findByID(Id);
    }
}
