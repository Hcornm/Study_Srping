package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 3. 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        // 두 값으 참조값이 다름
        // 클라이언트가 memberSer vice를 두번 호출하면 memberService 객체가 두개 생성 되는 것임
        // 요청이 많아 질 수록 객체가 계속해서 만들어지는 문제가 있다.
        // 스프링 없는 순수한 DI컨테이너의 문제점

        // 해결방안 => 해당 객체가 딱 한번 생성되고 공유되도록 설게 -> 싱글톤 패턴
        // 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
        // 객체 인스턴스가 2개 이상 생성되지 못하도록 막아야한다.


    }

//    public static void main(String[] args) {
//        // SingletonService에서 생성자를 private로 막아놨기 때문에 다른 영역에서 new로 생성 불가
//        SingletonService SingletonService = new SingletonService();
//    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        // 호출할 때마다 객체를 생성하는 지 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        // 객체 레퍼런스가 같다.
        // 즉 호출할 때마다 새로 객체를 생성하는 것이 아닌 자바 실행 시 최초록 1회만 생성 후 static영역에 가지고 있고
        // 호출할 때 마다 static영역에 있는 레퍼런스를 호출해서 객체를 가지고 온다.
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

        // 스프링 컨테이너를 사용하면 AppConfig를 모두 싱글톤패턴으로 수정할 필요없이
        // 스프링 컨테이너가 자동으로 싱글톤패턴을 적용해준다.
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        // AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 3. 참조값이 동일한 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }
}
