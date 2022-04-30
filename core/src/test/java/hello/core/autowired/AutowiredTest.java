package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    /**
     * 옵션 처리
     * 주입할 스프링 빈 없어도 동작해야할 때가 있다.
     * 그런데 @Autowired만 사용하면 required 옵션의 기본값이 true로 되어 있어서 자동주입대상이 없으면 오류발생
     *
     * 자동 주입대상을 옵셔널로 처리하는 방법
     * 1. @Autowired(required = false)를 사용하면 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
     * 2. org.springframework.lang.@Nullable 을 사용하면 자동 주입할 대상이 없으면 NULL이 입력된다.
     * 3. Optional<> 자바8에 추가된 것으로 자동 주입대상이 없으면 Optional.empty가 입력된다.
     *
     */


    static class TestBean {
        @Autowired(required = false)
        // 호출 자체가 안된다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
            //  noBean2 = null
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
            // noBean3 = Optional.empty
        }
    }
}
