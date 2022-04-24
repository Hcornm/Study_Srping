package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepositoy;

// 주문 구현체
public class OrderServiceImpl implements OrderService {


    // private final MemberRepository memberRepository = new MemoryMemberRepositoy();

    // 고정 할인정책
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 정률 할인정책
    // 여전히 구현체에 의존하고 있다.
    // 그리고 할인정책을 변경했다고 service구현체의 코드를 수정하는 것은 OCP 위반이다.
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 값을 무조건 할당해 줘야하는 final을 지우고 뒤의 구현체 선언도 같이 지워버리면 앞으로 할인정책에 관련된
    // 구현체들을 수정하더라도 Order구현체에서 OCP위반을 하지 않고 할인 정책을 변경할 수 있다.
    // 추상화인 인터페이스만 의존
    // private DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
