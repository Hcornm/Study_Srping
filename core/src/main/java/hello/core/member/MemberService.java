package hello.core.member;

// 회원 서비스
public interface MemberService {

    // 가입
    void join(Member member);

    // 회원 찾기
    Member findMember(Long memberId);
}
