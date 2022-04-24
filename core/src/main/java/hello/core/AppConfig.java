package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepositoy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 사용할 구현체를 리턴
    // 실제로 멤모리멤버 리포지토리에서 디비멤버리포지토리로 바꿔야하면 return 해주는 부분만 변경해주면
    // 소스 전체를 수정할 필요없이 서비스가 디비멤버리포지토리로 변경됨
    public MemberRepository memberRepository() {
        return new MemoryMemberRepositoy();
    }

    // 사용할 구현체를 리턴
    // 마찬가지로 할인정책을 변경하고 싶으면 return 부분만 변경해주면된다.
    // RateDiscountPolicy
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

    // 구현체를 가지고있는 인터페이스를 호출
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 구현체를 가지고있는 인터페이스를 호출
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


}
