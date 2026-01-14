package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        //@Configuration이 붙은 AppConfig 등을 등록하는 것을 막기 위해서 설정한다.
        basePackages = "hello.core"
        //Component 스캔을 시작할 시작위치를 지정한다.
        //쓰지 않으면, @ComponentScan 붙은 클래스의 패키지 위치에서 스캔을 시작한다.(여기에선 hello.core부터)
)
public class AutoAppConfig {
    /**
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    **/
}
