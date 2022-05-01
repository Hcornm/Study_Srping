package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepositoy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {


    // 생성자 주입을 사용해야하는 이유
    // 1. 프레임워크에 의존하지 않고 순수 자바언어의 특징을 잘 살리는 방식이다.
    // 2. final 키워드를 먹일 수 있다.
    //    -> 다른 곳에서 임의로 수정할 수 없다.
    //    -> 생성자에서 혹시라도 값이 설정되지 않으면 컴파일 단계에서 오류를 막아주기 때문에 오류가 난채로
    //        소소를 Run할 수 없게 막아준다.


    @Test
    void createOrder() {
        MemoryMemberRepositoy memberRepositoy = new MemoryMemberRepositoy();
        memberRepositoy.save(new Member(1L, "name", Grade.VIP));


        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepositoy(), new FixDiscountPolicy());
        Order order =  orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
