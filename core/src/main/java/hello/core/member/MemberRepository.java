package hello.core.member;

// 인터페이스
public interface MemberRepository {

    // 회원 저장
    void save(Member member);

    // id로 회원 찾기
    Member findById(Long memerId);
}
