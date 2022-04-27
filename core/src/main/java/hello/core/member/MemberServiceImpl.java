package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 구현체가 하나만 있을 때는 인터페이스명 뒤에 Impl을 븥이는 게 관례
@Component
public class MemberServiceImpl implements MemberService {

    // 서비스 구현체가 멤버를 찾고 가입시킬려면 MemberRepository가 필요하다.
    // 인터페이스                                      = 구현체
    // 다형성
    // 이코드의 단점은 인터페이스(추상화) 뿐만 아니라 구현체까지 의존하고 있음 DIP위반
    // private final MemberRepository memberRepository = new MemoryMemberRepositoy();

    // 이러면 추상화에만 의존한다
    private final MemberRepository memberRepository;

    // 생성자 주입
    @Autowired // = ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
