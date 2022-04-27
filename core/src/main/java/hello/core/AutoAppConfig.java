package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @ComponentScan을 사용하면 @Component 어노테이션이 붙은 클래스를 자동으로 스캔해서 스프링 빈으로 등록한다.
// 다른 Config 파일에 등록된 @Configuration 어노테이션 때문에 자동 컴포넌트 스캔 시 충동이 날 수 있다. Configuration 어노테이션의 자바 소스파일에
// 이미 @Component가 붙어있기 때문이다.
// 충동을 방지하기 위해 Configuration어노테이션이 붙은 클레스는 자동 빈 등록 시 제외한다.
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {



}
