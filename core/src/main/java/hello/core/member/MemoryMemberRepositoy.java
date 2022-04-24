package hello.core.member;


import java.util.HashMap;
import java.util.Map;

// 구현체
public class MemoryMemberRepositoy  implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memerId) {
        return store.get(memerId);
    }
}
