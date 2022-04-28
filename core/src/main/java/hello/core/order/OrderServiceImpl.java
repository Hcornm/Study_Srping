package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 주문 구현체
@Component
public class OrderServiceImpl implements OrderService {
    // 의존관계 주입 4가지 방법
    // 1. 생성자 주입
    // 2. 수정자 주입(setter)
    // 3. 필드주입
    // 4. 일반 메서드 주입


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
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    // 3.필드 주입방식
    // 이름 그대로 필드에 바로 주입하는 방식
    // 코드가 간결하지만 외부에서 변경이 불가능해서 테스트하기 힘들다는 치명적인 단점이 존재한다. DI프레임워크가 없으면 아무것도 할 수 없다.
    // 최근 추세는 필드 주입방식을 사용하지 않는 것이다. 사용지양
//    @Autowired
//    private MemberRepository memberRepository;

    // 2. 수정자 주입방식
    // setter 방식으로 의존관계 주입
    // 선택, 변경 가능성이 있는 의존관계에 사용
    // 자바빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법
    // 선택적 의존관계 주입이 필요할 때 쓰이며 순서는 생성자 의존관계 주입이 먼저 일어나고 그 다음이 수정자 주입방식이 일어난다.
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 4. 일반메서드 주입
    // 일반 메서드에 @Autowired 어노테이션을 등록해서 주입 받을 수 있다.
    // 한번에 여러 필드를 주입 할 수 있다.
    // 일반적으로 사용하지 않음
//    @Autowire이
//       // 일반 메서드
//    Public void init(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 1. 생성자 주입방식
    // 이름 그대로 생성자를 통해서 의존관계를 주입하는 방법
    // 생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.
    // 불변, 필수 의존관계에 사용된다.
    @Autowired
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
