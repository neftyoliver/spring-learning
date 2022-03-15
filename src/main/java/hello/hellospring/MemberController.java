package hello.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    //@Autowired
    public MemberController(MemberService pMemberService) {
        this.memberService = pMemberService;
    }
}
