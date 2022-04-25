package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        ApplicationContext를 스프링 컨테이너라고한다.
//        스프링 컨테이너는 @Configuration 어노테이션이 붙은 AppConfig.java를 설정 정보로 사용한다.
//        여기서 @Bean이라고 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다. 이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라고 한다.
//
//        이전에는 개발자가 직접 필요한 객체를 AppConfig를 사용해서 직접 조회했지만 이제부터는 스프링컨테이너를 통해서 필요한 스프링 빈을 찾아야한다.
//        필요한 스프링 빈을 찾는 방법은 applicationContext.getBean()메서드를 사용하며 첫 번째 인자값으로는 @Bean으로 등록한 객체의 이름을(일치해야함),
//        두 번째 인자값으로는 반환 타입을 넣어주면 된다.

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);





        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 100000);
        System.out.println("order.calculatePrice2 =  " + Order.calculatePrice2());

        System.out.println("order" + order);
        System.out.println("order" + order.calculatePrice());
    }
}
