package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: 사용자A의 10000원 주문
        statefulService1.order("userA", 10000);

        // ThreadA: 사용자B의 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA: 사용자A의 주문 금액 조회
        // statefulService1로 조회했기 때문에 10000원이 나와야함
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        // 두번째 쓰레드에서 사용자B가 price를 20000원으로 바꿔놨기 때문에 인스턴스를 공유하는 이상
        // 사용자A의 price를 조회해도 수정된 20000원이 나옴
        // 서비스 차원에서 아주 치명적인 문제임;;

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
